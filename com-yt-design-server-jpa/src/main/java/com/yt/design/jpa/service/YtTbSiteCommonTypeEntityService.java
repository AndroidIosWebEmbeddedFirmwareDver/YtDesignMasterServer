package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

import java.util.List;

//商品（作品）、服务、需求统一类型表

public interface YtTbSiteCommonTypeEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteCommonTypeEntity> {

    /**
     * 通过Level查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<YtTbSiteCommonTypeEntity> findAllByLevel(YtTbSiteCommonTypeEntity input) throws JpaCommonException;
}
