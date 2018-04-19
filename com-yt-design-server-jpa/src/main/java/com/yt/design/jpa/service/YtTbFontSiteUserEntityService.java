package com.yt.design.jpa.service;


import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbFontSiteUserEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

public interface YtTbFontSiteUserEntityService extends YtTbFontSiteCommonEntityService<YtTbFontSiteUserEntity> {


    /**
     * 主站注册用户
     *
     * @param input
     * @return
     * @throws JpaCommonException
     */
    public YtTbFontSiteUserEntity fontSiteCreate(YtTbFontSiteUserEntity input) throws Exception;

    /**
     * 主站登录用户
     *
     * @param input
     * @return
     * @throws JpaCommonException
     */
    public YtTbFontSiteUserEntity fontSiteLogin(YtTbFontSiteUserEntity input) throws JpaCommonException, Exception;
}
