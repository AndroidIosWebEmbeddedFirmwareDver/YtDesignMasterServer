package com.yt.design.jpa.service;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbSiteConfigFilesCenterEntity;
import com.yt.design.jpa.service.common.YtTbFontSiteCommonEntityService;

public interface YtTbSiteConfigFilesCenterEntityService extends YtTbFontSiteCommonEntityService<YtTbSiteConfigFilesCenterEntity> {
    /**
     * 查询一条
     *
     * @param fileUid 输入参数
     * @return 输出参数
     */
    public YtTbSiteConfigFilesCenterEntity findOneByFileUid(String fileUid) throws JpaCommonException;
}
