package temp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * To change this template use File | Settings | File Templates.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class TestLinkMap {
    public static void main(String[] args) {
        Map map=new LinkedHashMap();
        for(int i=0;i<10;i++){
            map.put(i,i+"abc");
        }
        map.get(1);
        map.get(3);
        map.get(5);
        System.out.println(map);
    }
}
