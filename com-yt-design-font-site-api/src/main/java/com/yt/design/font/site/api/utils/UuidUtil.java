package com.yt.design.font.site.api.utils;

import java.util.Date;
import java.util.UUID;

public class UuidUtil {
    public static String randomUuidStr() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();
    }

    public static String randomUuidStrForOrderNum() {
        return "HNN"
                + new Date().getTime() + randomUuidStr();
    }

    public static String randomUuidStrForSmsTag() {
        return new Date().getTime() + randomUuidStr();
    }
}
