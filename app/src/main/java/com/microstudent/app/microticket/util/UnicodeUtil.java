package com.microstudent.app.microticket.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * unicode编码转换
 * Created by MicroStudent on 2016/4/7.
 */
public final class UnicodeUtil {

    public static String unicodeToString(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }

}
