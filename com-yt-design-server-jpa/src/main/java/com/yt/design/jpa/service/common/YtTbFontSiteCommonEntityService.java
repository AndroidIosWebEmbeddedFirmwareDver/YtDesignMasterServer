package com.yt.design.jpa.service.common;

import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;

import java.util.List;

public interface YtTbFontSiteCommonEntityService<T> {
    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public T create(T input) throws JpaCommonException;

    /**
     * 删除
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public T delete(T input) throws JpaCommonException;

    /**
     * 修改
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public T update(T input) throws JpaCommonException;

    /**
     * 查询一条
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public T findOne(T input) throws JpaCommonException;

    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public List<T> find(T input) throws JpaCommonException;

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public DbDataCommonPageDownEntity<List<T>> findPages(DbDataCommonPageQueryEntity<T> input) throws JpaCommonException;
}
