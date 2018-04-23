package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommodityOrderEntity;
import com.yt.design.jpa.entity.YtTbSiteConfigAdsEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

import java.util.List;

public interface YtTbSiteConfigAdsEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteConfigAdsEntity> {

    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<YtTbSiteConfigAdsEntity> findAll(YtTbSiteConfigAdsEntity input) throws JpaCommonException;

}
