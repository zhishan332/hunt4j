import com.yermoon.hunt4j.Hunt4j;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertTrue;

/**
 * test Hunt4j
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestHunt4j {

    @Test
    public void testGetHtml() throws Exception {
        Hunt4j hunt4j = new Hunt4j();
        long b = System.currentTimeMillis();
        String str = hunt4j.getHtml("http://www.yermoon.com/");
        long e = System.currentTimeMillis();
        assertTrue(str != null);
        assertTrue(str.length() > 50);
        assertTrue((e - b) < 1000 * 5);
    }
}
