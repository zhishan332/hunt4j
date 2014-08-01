package other;

import com.yermoon.parser.util.UrlUtil;
import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestJsoup {
    @Test
    public void test() throws IOException {
        String url="http://www.huaban.com";
        Document doc = Jsoup.connect(url).get();
        String topUrl= UrlUtil.getTopUrl(url);
        Elements links = doc.getElementsByTag("a"); // 具有 href 属性的链接
        for (Element link : links) {
            String linkHref = link.absUrl("href");
            String classd=link.attr("class");
            String target=link.attr("target");
            String id=link.attr("id");
            String title=link.attr("title");
            System.out.println("id:"+id);
            System.out.println("id:"+id);
            System.out.println("cls:"+classd);
            System.out.println("title:"+title);
            System.out.println("linkHref:"+linkHref);
            System.out.println("text:"+link.text());
            if (StringUtils.isBlank(linkHref) || !linkHref.contains(topUrl)) {
                continue;
            }
            String[] arry = linkHref.split("http://");
            Set<String> newLinkSet = new HashSet<String>();
            for (String str : arry) {
                if (StringUtils.isBlank(str)) continue;
                newLinkSet.add("http://" + str);
            }
            for (String newLink : newLinkSet) {


            }
        }
    }
}
