package com.yt.design.exception;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:58
 **/

public class RequestCommonException extends Exception {

    @Override
    public String getMessage() {
        String DEFAULT_JPA_EXCEPTION = "请求数据异常，请稍后重试。";
        if (super.getMessage() != null)
            return super.getMessage();
        else
            return DEFAULT_JPA_EXCEPTION;
    }
}
