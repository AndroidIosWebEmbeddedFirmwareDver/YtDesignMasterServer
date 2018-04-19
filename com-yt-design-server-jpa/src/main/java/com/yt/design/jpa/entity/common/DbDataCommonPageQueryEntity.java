package com.yt.design.jpa.entity.common;

import com.yt.design.exception.DataCheckCommonException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description a
 * @Author
 * @Create 2018-04-11 下午11:55
 **/

@Data

@ApiModel(description = "通用接口分页查询实体")
public class DbDataCommonPageQueryEntity <T>{
    @ApiModelProperty(value = "页数，从0开始")
    int page;
    @ApiModelProperty(value = "大小个数，大于0")
    int size;
    @ApiModelProperty(value = "排序字段，可以为空，为空是默认排序")
    String sortType;
    @ApiModelProperty(value = "排序方式，0-升序DESC，1-降序SEC")
    int sortDirecion;
    @ApiModelProperty(value = "附加查询值")
    T data;


    public boolean dataCheckForFindPages(DbDataCommonPageQueryEntity input) throws DataCheckCommonException {
        if (input == null) {
            throw new DataCheckCommonException();
        }
        if (input.getSize() <= 0 || input.getPage() < 0) {
            throw new DataCheckCommonException();
        }
        return true;
    }
}
