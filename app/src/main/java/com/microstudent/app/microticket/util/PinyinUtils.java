package com.microstudent.app.microticket.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * Created by MicroStudent on 2016/4/30.
 */
public class PinyinUtils {
    public static char getPinyinLetter(String s, int index) {
        if (!s.isEmpty() && index >= 0 && index < s.length()) {
            String[] result = PinyinHelper.toHanyuPinyinStringArray(s.charAt(index));
            if (result != null) {
                return result[0].charAt(0);
            }
        }
        return ' ';
    }
}
