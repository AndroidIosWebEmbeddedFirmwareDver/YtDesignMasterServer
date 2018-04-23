package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteShotMessageSmsEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

import java.util.List;

public interface YtTbSiteShotMessageSmsEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteShotMessageSmsEntity> {


    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<YtTbSiteShotMessageSmsEntity> findAll(YtTbSiteShotMessageSmsEntity input) throws JpaCommonException;
}
