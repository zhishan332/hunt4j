package com.yermoon.server.helper;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * webpage的一些帮助方法
 *
 * @author wangqing
 * @since 14-5-19 下午3:05
 */
public class PageHelper {
    private static final Logger log = LoggerFactory.getLogger(PageHelper.class);
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式


    public static String addStrongTag(String str, String key) {
        if (StringUtils.isBlank(key)) return str;
        int index = str.indexOf(key);
        String newStr = str;
        if (index > -1) {
            String[] arry = str.split(key);
            newStr = "";
            for (int a = 0; a < arry.length; a++) {
                if (a % 2 == 0) {
                    newStr += arry[a] + "<strong>" + key + "</strong>";
                } else {
                    newStr += arry[a];
                }
            }
        }
        return newStr;
    }

    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 去除字符串中所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     * @param s
     * @return
     */
    public static String removeAllBlank(String s){
        String result = "";
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("[　*| *|&nbsp;*|//s*]*", "");
            result=result.replaceAll("[\\s\\p{Zs}]+", "");
        }
        return result;
    }

    public static boolean isValidUrl(String regx,String url){
        Pattern pat = Pattern.compile(regx,Pattern.DOTALL|Pattern.CASE_INSENSITIVE);
        Matcher dd = pat.matcher(url);
        return dd.find();
    }
}
