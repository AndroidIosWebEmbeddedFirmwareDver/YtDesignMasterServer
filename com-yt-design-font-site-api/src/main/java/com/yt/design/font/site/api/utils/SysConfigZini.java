package com.yt.design.font.site.api.utils;

/**
 * @Description 系统参数
 * @Author
 * @Create 2017-11-17 上午11:42
 **/

public class SysConfigZini {

    public static int Z_INI_KEY_VALUE_OPEN = 1;//系统配置VALUE，默认0，1-打开，0-关闭
    public static int Z_INI_KEY_VALUE_CLOSE = 0;//系统配置VALUE，默认0，1-打开，0-关闭
    public static String Z_INI_KEY_OF_AUTO_RNA = "z_auto_rna";
    public static String Z_INI_KEY_OF_VALID_FAST_SMS = "z_valid_fast_sms";

    public static enum Z_INI_VALUES_OF_RNA {
        UN_COMMIT,//未提交，待提交
        COMMITED_WAIT_EXAM,//已提交，待审核
        EXAMED_NOT_PASS,//已审核，未通过
        EXAMED_PASSED,//已审核，已通过
    };
}
