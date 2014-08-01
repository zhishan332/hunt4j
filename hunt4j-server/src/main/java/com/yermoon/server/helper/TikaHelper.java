package com.yermoon.server.helper;

import org.apache.commons.lang.StringUtils;
import org.apache.tika.exception.TikaException;
import org.apache.tika.io.IOUtils;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.springframework.stereotype.Component;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-23 下午1:40
 */
@Component
public class TikaHelper {
   private  ImageSavingParser imageParser;

    public static void main(String[] args) throws Exception {
        TikaHelper tt = new TikaHelper();
        Metadata md = tt.getImgInfo("http://www.sinaimg.cn/dy/slidenews/5_t500/2014_21/18966_1013450_246885.jpg");
        System.out.println(md.get("Content-Encoding"));
        System.out.println(md.get("Content-Length"));
    }

    public Metadata getMetaInfo(String urlStr) throws Exception {
        if (StringUtils.isBlank(urlStr)) return null;
        URL url = new URL(urlStr);
        Metadata md = new Metadata();
        TikaInputStream stream = TikaInputStream.get(url, md);
        try {
            ContentHandler handler = new TeeContentHandler();
            Parser parser = new AutoDetectParser();
            parser.parse(stream, handler, md, new ParseContext());
        } finally {
            stream.close();
        }
        return md;
    }

    public Metadata getImgInfo(String urlStr) throws Exception {
        if (StringUtils.isBlank(urlStr)) return null;
        URL url = new URL(urlStr);
        Metadata md = new Metadata();
        StringWriter htmlBuffer = new StringWriter();
        Parser parser = new  AutoDetectParser();
        imageParser= new ImageSavingParser(parser);
        TikaInputStream stream = TikaInputStream.get(url, md);
        try {
            ContentHandler handler = new TeeContentHandler(getHtmlHandler(htmlBuffer));
            parser.parse(stream, handler, md, new ParseContext());
        } finally {
            stream.close();
        }
        return md;
    }
    private  ContentHandler getHtmlHandler(Writer writer)
            throws TransformerConfigurationException {
        SAXTransformerFactory factory = (SAXTransformerFactory)
                SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();
        handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
        handler.setResult(new StreamResult(writer));
        return new ContentHandlerDecorator(handler) {
            @Override
            public void startElement(
                    String uri, String localName, String name, Attributes atts)
                    throws SAXException {
                if (XHTMLContentHandler.XHTML.equals(uri)) {
                    uri = null;
                }
                if (!"head".equals(localName)) {
                    if("img".equals(localName)) {
                        AttributesImpl newAttrs;
                        if(atts instanceof AttributesImpl) {
                            newAttrs = (AttributesImpl)atts;
                        } else {
                            newAttrs = new AttributesImpl(atts);
                        }

                        for(int i=0; i<newAttrs.getLength(); i++) {
                            if("src".equals(newAttrs.getLocalName(i))) {
                                String src = newAttrs.getValue(i);
                                if(src.startsWith("embedded:")) {
                                    String filename = src.substring(src.indexOf(':')+1);
                                    try {

                                        File img = imageParser.requestSave(filename);
                                        String newSrc = img.toURI().toString();
                                        newAttrs.setValue(i, newSrc);
                                    } catch(IOException e) {
                                        System.err.println("Error creating temp image file " + filename);
                                        // The html viewer will show a broken image too to alert them
                                    }
                                }
                            }
                        }
                        super.startElement(uri, localName, name, newAttrs);
                    } else {
                        super.startElement(uri, localName, name, atts);
                    }
                }
            }
            @Override
            public void endElement(String uri, String localName, String name)
                    throws SAXException {
                if (XHTMLContentHandler.XHTML.equals(uri)) {
                    uri = null;
                }
                if (!"head".equals(localName)) {
                    super.endElement(uri, localName, name);
                }
            }
            @Override
            public void startPrefixMapping(String prefix, String uri) {
            }
            @Override
            public void endPrefixMapping(String prefix) {
            }
        };
    }
    /**
     * A recursive parser that saves certain images into the temporary
     *  directory, and delegates everything else to another downstream
     *  parser.
     */
    private static class ImageSavingParser extends AbstractParser {
        private Map<String,File> wanted = new HashMap<String,File>();
        private Parser downstreamParser;
        private File tmpDir;

        private ImageSavingParser(Parser downstreamParser) {
            this.downstreamParser = downstreamParser;

            try {
                File t = File.createTempFile("tika", ".test");
                tmpDir = t.getParentFile();
            } catch(IOException e) {}
        }

        public File requestSave(String embeddedName) throws IOException {
            String suffix = ".tika";

            int splitAt = embeddedName.lastIndexOf('.');
            if (splitAt > 0) {
                embeddedName.substring(splitAt);
            }

            File tmp = File.createTempFile("tika-embedded-", suffix);
            wanted.put(embeddedName, tmp);
            return tmp;
        }

        public Set<MediaType> getSupportedTypes(ParseContext context) {
            // Never used in an auto setup
            return null;
        }

        public void parse(InputStream stream, ContentHandler handler,
                          Metadata metadata, ParseContext context) throws IOException,
                SAXException, TikaException {
            String name = metadata.get(Metadata.RESOURCE_NAME_KEY);
            if(name != null && wanted.containsKey(name)) {
                FileOutputStream out = new FileOutputStream(wanted.get(name));
                IOUtils.copy(stream, out);
                out.close();
            } else {
                if(downstreamParser != null) {
                    downstreamParser.parse(stream, handler, metadata, context);
                }
            }
        }

    }
}
