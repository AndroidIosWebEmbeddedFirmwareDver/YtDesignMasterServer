package com.yt.design.entity.common;

import lombok.Data;

@Data
public class JsonResponseStatus {
    public static int CODE_SERER_HANDLE_SUCCESS = 1001;
    public static String MSG_SERER_HANDLE_SUCCESS = "成功";
    public static int CODE_SERER_HANDLE_FAILED = 1002;
    public static String MSG_SERER_HANDLE_FAILED = "失败";
    public static int CODE_SERER_HANDLE_TIMEOUT = 1003;
    public static String MSG_SERER_HANDLE_TIMEOUT = "超时";
}
