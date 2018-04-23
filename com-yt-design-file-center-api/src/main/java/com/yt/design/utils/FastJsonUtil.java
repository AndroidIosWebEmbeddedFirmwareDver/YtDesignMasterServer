package com.yt.design.utils;

import com.alibaba.fastjson.JSON;

/**
 * @Description 阿里巴巴 FastJson工具
 * @Author
 * @Create 2017-12-14 下午2:34
 **/

public class FastJsonUtil {

    public static String encode(Object o) {
        if (o == null) {
            return null;
        }
        return JSON.toJSONString(o);
    }

    public static <T> T decode(String jsonStr, Class<T> c) {
        if (jsonStr == null || jsonStr.isEmpty()) {
            return null;
        }
        return JSON.parseObject(jsonStr, c);
    }
}
