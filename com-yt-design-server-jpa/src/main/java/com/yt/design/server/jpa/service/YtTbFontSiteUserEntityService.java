package com.yt.design.server.jpa.service;

import com.yt.design.server.common.exception.JpaCommonException;
import com.yt.design.server.jpa.entity.YtTbFontSiteUserEntity;

import java.util.List;

public interface YtTbFontSiteUserEntityService {
    /**
     * 新增
     *
     * @param input
     * @return
     */
    public YtTbFontSiteUserEntity create(YtTbFontSiteUserEntity input) throws JpaCommonException;

    /**
     * 删除
     *
     * @param input
     * @return
     */
    public YtTbFontSiteUserEntity delete(YtTbFontSiteUserEntity input) throws JpaCommonException;

    /**
     * 修改
     *
     * @param input
     * @return
     */
    public YtTbFontSiteUserEntity update(YtTbFontSiteUserEntity input) throws JpaCommonException;

    /**
     * 查询一条
     *
     * @param input
     * @return
     */
    public YtTbFontSiteUserEntity findOne(YtTbFontSiteUserEntity input) throws JpaCommonException;

    /**
     * 查询一堆
     *
     * @param input
     * @return
     */
    public List<YtTbFontSiteUserEntity> find(YtTbFontSiteUserEntity input) throws JpaCommonException;
}
