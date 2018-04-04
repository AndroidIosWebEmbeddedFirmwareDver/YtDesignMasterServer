package com.yt.design.server.common.exception;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午2:03
 **/

public class DataCheckCommonException extends Exception {

    @Override
    public String getMessage() {
        String DEFAULT_JPA_EXCEPTION = "输入参数不规范";
        if (super.getMessage() != null)
            return super.getMessage();
        else
            return DEFAULT_JPA_EXCEPTION;
    }
}
