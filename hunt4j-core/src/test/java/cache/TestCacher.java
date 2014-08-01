package cache;

import com.yermoon.hunt4j.core.cache.DefultCacheManager;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test  DefultCacheManager
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestCacher {

    @Test
    public void testa() {
        DefultCacheManager.getInstance().getCache().put("abc", "中国");
        assertEquals("中国", DefultCacheManager.getInstance().getCache().get("abc"));
    }
}
