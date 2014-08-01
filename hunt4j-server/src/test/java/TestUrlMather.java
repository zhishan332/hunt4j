import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestUrlMather {
    @Test
    public void test1(){
        String url = "http://www.douban.com/group/topic/57541430";
        String reg="douban\\.com/group/topic/\\d+/?$";
        Pattern p=Pattern.compile(reg,Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
        Matcher mm = p.matcher(url);
        System.out.println(mm.find());
    }
}
