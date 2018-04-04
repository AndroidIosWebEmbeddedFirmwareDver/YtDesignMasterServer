package com.yt.design.server.common.exception;

import java.security.PrivilegedActionException;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:58
 **/

public class JpaCommonException extends Exception {

    @Override
    public String getMessage() {
        String DEFAULT_JPA_EXCEPTION = "数据库操作异常";
        if (super.getMessage() != null)
            return super.getMessage();
        else
            return DEFAULT_JPA_EXCEPTION;
    }
}
