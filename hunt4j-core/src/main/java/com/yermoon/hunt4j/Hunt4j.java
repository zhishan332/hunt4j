package com.yermoon.hunt4j;

import com.yermoon.hunt4j.core.http.DefalutHunter;
import com.yermoon.hunt4j.core.http.Hunter;
import com.yermoon.hunt4j.core.http.SimpleDownLoader;

/**
 * Facade class for accessing Hunt4j functionality. This class hides much of
 * the underlying complexity of the lower level Hunt4j classes and provides
 * simple methods for many  operations.
 *
 * @author wangqing
 * @since 1.0.0
 */
public class Hunt4j {
    private Hunter hunter;

    public Hunt4j() {
        this.hunter = new DefalutHunter(new SimpleDownLoader(36));
    }

    public Hunt4j(Hunter hunter) {
        this.hunter = hunter;
    }

    public String getHtml(String url) throws Exception {
        return hunter.getHtml(url,"UTF-8", 10);
    }

    public String getHtml(String url,String charsetName,int timeout) throws Exception {
        return hunter.getHtml(url,charsetName, timeout);
    }


}
