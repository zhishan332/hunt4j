package com.yermoon.server.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 字符串格式化的工具类
 *
 * @author wangqing
 * @since 14-5-19 下午1:44
 */
public class StringFormatUtil {

    /**
     * 过滤特殊字符和空格
     *
     * @param str
     * @return
     * @throws java.util.regex.PatternSyntaxException
     */
    public static String filter(String str) throws PatternSyntaxException {
        if(StringUtils.isBlank(str)) return "";
        // 只允许字母和数字
        // String   regEx  =  "[^a-zA-Z0-9]";
        // 清除掉所有特殊字符
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll(" ").trim().replaceAll("\\s*","");
    }

    public static void main(String[] args) {
        String str="你好, dd ";
        System.out.println(StringFormatUtil.filter(str));
    }
}
