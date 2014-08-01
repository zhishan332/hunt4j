package tika;

import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.TeeContentHandler;
import org.xml.sax.ContentHandler;

import java.net.URL;
import java.util.Arrays;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-23 下午1:27
 */
public class TestParse {
    public static void main(String[] args)throws Exception{
        URL url=new URL("http://pic.daqi.com/slide/3597465_5.html");
        Metadata md = new Metadata();
        TikaInputStream stream = TikaInputStream.get(url, md);
        StringBuilder metadataBuffer = new StringBuilder();
        ContentHandler handler = new TeeContentHandler();
        Parser parser = new AutoDetectParser();
        parser.parse(stream, handler, md,  new ParseContext());
        String[] names = md.names();
        Arrays.sort(names);
        for (String name : names) {
            metadataBuffer.append(name);
            metadataBuffer.append(": ");
            metadataBuffer.append(md.get(name));
            metadataBuffer.append("\n");
        }
        String name = md.get(Metadata.RESOURCE_NAME_KEY);
        if (name != null && name.length() > 0) {
            System.out.println("Apache Tika: " + name);
        } else {
            System.out.println("Apache Tika: unnamed document");
        }
        System.out.println("metadata");
        System.out.println(metadataBuffer.toString());
    }
//    Apache Tika: 3597465_5.html
//            metadata
//    Content-Encoding: GB2312
//    Content-Length: 23966
//    Content-Type: text/html; charset=gb2312
//    dc:title: 【图】女主播各种门 引人遐想无限
//    description: 大旗贴图频道是年轻人的新锐视觉的聚合门户。聚合网友创造的有独特视觉感的图片，带给他们最健康、最鲜活、最独特的精神生活。
//    keywords: 贴图论坛、图片搜索、美女图片、写真、lomo、自拍。
//    resourceName: 3597465_5.html
//    title: 【图】女主播各种门 引人遐想无限

}
