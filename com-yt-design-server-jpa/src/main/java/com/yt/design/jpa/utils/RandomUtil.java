package com.yt.design.jpa.utils;

import java.util.Random;

public class RandomUtil {


    public static int getRandomNum(int max, int min) {

        Random random = new Random();

        return random.nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 获取4位随机验证码
     *
     * @return
     */
    public static String getValidationCode() {
        return String.valueOf((new Random().nextInt(8999) + 1000));
    }


    /**
     * 获取指定位数的随机字符串(包含小写字母、大写字母、数字,0<length)
     *
     * @param length
     * @return
     */
    public static String getRandomString(long length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }
}
