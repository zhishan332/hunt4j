package com.yermoon.parser;

import com.yermoon.hunt4j.Hunt4j;
import com.yermoon.hunt4j.core.http.SimpleDownLoader;
import com.yermoon.parser.pojo.WebPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class JsoupHtmlParserTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParse() throws Exception {
        Hunt4j hunt4j = new Hunt4j();
        String url = "http://www.topit.me/";
        String str = hunt4j.getHtml(url);
        for(int i=0;i<10;i++){
            HtmlParser htmlParser = new JsoupHtmlParser(new SimpleImageParser(new SimpleDownLoader(16)));
            WebPage dd = htmlParser.parse(str, url);
            String title = dd.getTitle();
            System.out.println(title);
        }
    }
}
