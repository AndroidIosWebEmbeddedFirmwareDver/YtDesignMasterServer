package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteConfigPartnersEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

import java.util.List;

public interface YtTbSiteConfigPartnersEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteConfigPartnersEntity> {


    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<YtTbSiteConfigPartnersEntity> findAll(YtTbSiteConfigPartnersEntity input) throws JpaCommonException;
}
