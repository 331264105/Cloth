package com.didu.utils;

import java.util.Random;

/**
 * Created by Administrator on 2017/11/14.
 */
public class payUtils {
    /**
     * 自定义长度随机字符串
     * @param length
     * @return
     */
    public static String createConceStr(int length) {
        String strs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String str = "";
        for (int i = 0; i < length; i++) {
            // str +=strs.substring(0, new Random().nextInt(strs.length()));
            char achar = strs.charAt(new Random().nextInt(strs.length() - 1));
            str += achar;
        }
        return str;
    }
}
