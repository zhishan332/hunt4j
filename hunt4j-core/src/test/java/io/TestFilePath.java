package io;

import com.yermoon.hunt4j.core.io.FileUtils;
import org.junit.Test;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestFilePath {

    @Test
    public void testGetPath() {
        String pt = System.getProperty("user.dir");
        System.out.println(pt);
    }

    @Test
    public void testGetCheckedPath() {
        System.out.println(FileUtils.getCheckedPath(null));
        System.out.println(FileUtils.getCheckedPath("D:\\code\\idea\\search\\hunt4j\\hunt4j-server\\src\\main"));
        System.out.println(FileUtils.getCheckedPath("D:\\code\\idea\\search\\hunt4j\\hunt4j-server\\src\\main\\"));
    }
    @Test
    public void testGetAutoFileName() {
        System.out.println(FileUtils.getAutoFileName(FileUtils.getWorkPath()));
    }
}
