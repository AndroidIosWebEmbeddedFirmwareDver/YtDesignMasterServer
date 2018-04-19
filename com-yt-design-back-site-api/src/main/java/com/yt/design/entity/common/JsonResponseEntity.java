package com.yt.design.entity.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

@ApiModel(description = "通用接口返回JSON实体")
public class JsonResponseEntity<T> {
    @ApiModelProperty(value = "处理代码，1001-成功，1002-失败，1003-超时")
    private int code;
    @ApiModelProperty(value = "处理消息")
    private String msg;
    @ApiModelProperty(value = "返回数据")
    private T data;

    public JsonResponseEntity() {
        this.code = 0;
    }

    public JsonResponseEntity(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResponseEntity(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResponseEntity init(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public void setBaseInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
