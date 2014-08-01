package com.yermoon.parser;


import com.yermoon.parser.pojo.Image;

/**
 * 网页图片分析器
 *
 * @author wangqing
 * @since 1.0.0
 */
public interface ImageParser {

    Image parse(String imgUrl);
}
