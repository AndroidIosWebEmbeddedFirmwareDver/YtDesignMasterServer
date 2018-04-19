package com.yt.design.jpa.entity.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description a
 * @Author
 * @Create 2018-04-18 下午9:49
 **/

@Data
public class DbDataCommonPageDownEntity<T> {
    @ApiModelProperty(value = "当前页面")
    int nowPage;
    @ApiModelProperty(value = "总数据条数")
    int totalSize;
    @ApiModelProperty(value = "返回数据")
    T data;
}
