package other;

import org.junit.Test;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestTempDir {
    @Test
    public void test(){
        String localConfigRoot = System.getProperty("java.io.tmpdir");
        System.out.println(localConfigRoot);
        String str=String.format("**","dd","ee");
        System.out.println(str);
    }
}
