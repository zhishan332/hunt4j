package com.yermoon.parser;


import com.yermoon.parser.pojo.WebPage;

/**
 * 网页分析器
 *
 * @author wangqing
 * @since 1.0.0
 */
public interface HtmlParser {

    WebPage parse(String htmlStr,String url);

}
