import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-16 下午8:35
 */
public class TestRegx {
    public static void main(String[] args) {
        String regEx = "//(www.)?(.*)(.com|.net|.cn|.org|.hk|.me|.cc|.net.cn|.asia|.com.cn|.co|.biz|.tw|.org.cn|.info|.io)";
        Pattern pat = Pattern.compile(regEx);
        Matcher dd = pat.matcher(" http://jandan.net/");
        if(dd.find()){
            System.out.println(dd.group(2));
        }

    }
}
