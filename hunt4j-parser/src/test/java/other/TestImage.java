package other;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestImage {

    @Test
    public void testImageIo() {
        File ff = new File("C:\\Users\\Administrator\\Pictures\\0ce2967529b279e4bdf449365aedf990.jpg");
        if (!ff.exists()) return;
        try {
            BufferedImage img = ImageIO.read(ff);
            int ww = img.getWidth();
            int hh = img.getHeight();
            assertTrue(ww == 680);
            assertTrue(hh == 479);
            long len = ff.length();
            assertTrue(len == 164946);

        } catch (IOException e) {
            e.printStackTrace();
            fail("出现异常");
        }
    }
}
