package com.yt.design.exception;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午2:03
 **/

public class DataCheckCommonException extends JpaCommonException {

    private String eDesc;

    public DataCheckCommonException() {
    }

    public DataCheckCommonException(String eDesc) {
        this.eDesc = eDesc;
    }


    @Override
    public String getMessage() {
        String DEFAULT_JPA_EXCEPTION = "输入参数不规范";
        if (eDesc != null && eDesc.length() > 0)
            return eDesc;
        else
            return DEFAULT_JPA_EXCEPTION;
    }
}
