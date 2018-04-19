package com.yt.design.jpa.entity.common;


import com.yt.design.exception.DataCheckCommonException;


public interface DbDataCommonDataEntityChecker {
    /**
     * 新增
     *
     * @return 检测结果
     */
    public boolean dataCheckForCreate() throws DataCheckCommonException;

    /**
     * 删除
     *
     * @return 检测结果
     */
    public boolean dataCheckForDelete() throws DataCheckCommonException;

    /**
     * 修改
     *
     * @return 检测结果
     */
    public boolean dataCheckForUpdate() throws DataCheckCommonException;

    /**
     * 查询一条
     *
     * @return 检测结果
     */
    public boolean dataCheckForFindOne() throws DataCheckCommonException;

    /**
     * 查询一堆
     *
     * @return 检测结果
     */
    public boolean dataCheckForFind() throws DataCheckCommonException;


//    /**
//     * 查询一堆分页数据
//     *
//     * 
//     * @return 检测结果
//     */
//    public boolean dataCheckForFindPages(DbDataCommonPageQueryEntity input) throws DataCheckCommonException;
}
