/**
 * Created with IntelliJ IDEA.
 * User: wangq
 * Date: 14-5-18
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */
public class TestImgUrlSplit {
    public static void main(String[] args) {
        String url="http://ww1.sinaimg.cn/mw600/59b2c10cjw1egbv4nq6zhj20cx0kuacq.jpg";
        String[] strs = url.split("/");
        String suffix=".jpg";
        System.out.println(strs[strs.length - 1].replace(suffix, ""));
    }
}
