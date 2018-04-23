package com.yt.design.exception;

import java.security.PrivilegedActionException;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午1:58
 **/

public class JpaCommonException extends Exception {
    private String eDesc;

    public JpaCommonException() {
    }

    public JpaCommonException(String eDesc) {
        this.eDesc = eDesc;
    }


    @Override
    public String getMessage() {
        String DEFAULT_JPA_EXCEPTION = "数据库操作异常";
        if (eDesc != null && eDesc.length() > 0)
            return eDesc;
        else
            return DEFAULT_JPA_EXCEPTION;
    }
}
