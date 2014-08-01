package http;


import com.yermoon.hunt4j.core.http.DefalutHunter;
import com.yermoon.hunt4j.core.http.SimpleDownLoader;
import com.yermoon.hunt4j.core.http.Hunter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestDefalutHunter {
    private Hunter hunter;

    @Before
    public void before() {
        SimpleDownLoader downloader=new SimpleDownLoader(36);
        hunter = new DefalutHunter(downloader);
    }

    @Test
    public void testGetHtml() {
        try {
            long a = System.currentTimeMillis();
            for(int i=0;i<10;i++){
                String str2 = hunter.getHtml("http://blog.csdn.net/");
                assertNotNull(str2);
            }
            long b = System.currentTimeMillis() - a;
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
