import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-21 上午11:33
 */
public class TestUrlencoder {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String url="http://tt.mop.com/";
        url = URLEncoder.encode(url, "UTF-8");
        System.out.println(url);
    }
}
