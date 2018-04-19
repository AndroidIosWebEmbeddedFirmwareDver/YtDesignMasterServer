package com.yt.design.controllers.common;


import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.exception.RequestCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface YtTbFontSiteCommonController<T> {

    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    public JsonResponseEntity<T> create(@RequestBody T input);

    /**
     * 删除
     *
     * @param input 输入参数
     * @return 输出参数
     */

    public JsonResponseEntity<T> delete(@RequestBody T input);

    /**
     * 修改
     *
     * @param input 输入参数
     * @return 输出参数
     */

    public JsonResponseEntity<T> update(@RequestBody T input);

    /**
     * 查询一条
     *
     * @param input 输入参数
     * @return 输出参数
     */

    public JsonResponseEntity<T> findOne(@RequestBody T input);

    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */

    public JsonResponseEntity<List<T>> find(@RequestBody T input);

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */

    public JsonResponseEntity<DbDataCommonPageDownEntity<List<T>>> findPages(@RequestBody DbDataCommonPageQueryEntity<T> input);
}
