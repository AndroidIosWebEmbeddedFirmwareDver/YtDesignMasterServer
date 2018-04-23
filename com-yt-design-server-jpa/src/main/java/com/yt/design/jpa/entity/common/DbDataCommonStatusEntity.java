package com.yt.design.jpa.entity.common;

/**
 * @Description
 * @Author
 * @Create 2018-04-02 下午4:27
 **/

public class DbDataCommonStatusEntity {


    public static enum DB_DATA_STSTUS_OF_IS_DELETED {
        NOTDELETE,
        DELETED,
    }

    //短信默认超时时间 :分钟
    public static final int DB_SITESHORTMESSAGESMS_SMS_INVALID_TIME = 10;

}
