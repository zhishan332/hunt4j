/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 14-5-21 下午1:58
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = " http://tt.mop.com/";
        String[] arry = str.split("http://");
        for(String dd:arry){
            if(dd.equals("http://")) continue;
            System.out.println("http://"+dd);
        }
    }
}
