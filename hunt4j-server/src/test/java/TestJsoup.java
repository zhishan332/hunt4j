import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-19 下午2:06
 */
public class TestJsoup {
    public static void main(String[] args) {
        String htmlStr="<!doctype html>\n" +
                "<html>\n" +
                "<head><meta charset=\"utf-8\">\n" +
                "<title>街拍 | 点点网轻博客</title><meta http-equiv=\"X-UA-Compatible\" content=\"IE=100\" />\n" +
                "<meta name=\"Description\" content=\"街拍的相关文章\" />\n" +
                "<meta name=\"Keywords\" content=\"街拍,时尚,搭配,欧美,潮流,fashion,混搭,模特,服饰,性感,lookbook,女装,服装,style,点点,点点网,博客,轻博客\" />\n" +
                "<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"http://s.srcdd.com/img/icon/favicon.$5106.ico\" /><!--[if lt IE 7]>";

        Document doc = Jsoup.parse(htmlStr);
        Elements eles = doc.select("meta");
        System.out.println(eles.size());
        for (Element link : eles) {
            System.out.println(link.attr("name"));
            System.out.println(link.attr("content"));
        }

    }
}
