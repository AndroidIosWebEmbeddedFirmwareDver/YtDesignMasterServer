package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteConfigCertChainEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

import java.util.List;

public interface YtTbSiteConfigCertChainEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteConfigCertChainEntity> {


    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<YtTbSiteConfigCertChainEntity> findAll(YtTbSiteConfigCertChainEntity input) throws JpaCommonException;
}
