package com.yt.design.server.jpa.service;

import com.yt.design.server.common.exception.DataCheckCommonException;
import com.yt.design.server.jpa.entity.YtTbFontSiteUserEntity;

public interface YtTbFontSiteUserEntityDataChecker {
    /**
     * 新增
     *
     * @param input
     * @return
     */
    public boolean dataCheckForCreate(YtTbFontSiteUserEntity input) throws DataCheckCommonException;

    /**
     * 删除
     *
     * @param input
     * @return
     */
    public boolean dataCheckForDelete(YtTbFontSiteUserEntity input) throws DataCheckCommonException;

    /**
     * 修改
     *
     * @param input
     * @return
     */
    public boolean dataCheckForUpdate(YtTbFontSiteUserEntity input) throws DataCheckCommonException;

    /**
     * 查询一条
     *
     * @param input
     * @return
     */
    public boolean dataCheckForFindOne(YtTbFontSiteUserEntity input) throws DataCheckCommonException;

    /**
     * 查询一堆
     *
     * @param input
     * @return
     */
    public boolean dataCheckForFind(YtTbFontSiteUserEntity input) throws DataCheckCommonException;
}
