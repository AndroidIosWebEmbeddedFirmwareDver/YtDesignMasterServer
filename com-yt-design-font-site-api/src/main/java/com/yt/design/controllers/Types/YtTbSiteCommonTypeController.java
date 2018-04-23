package com.yt.design.controllers.Types;

import com.yt.design.controllers.common.YtTbFontSiteCommonController;
import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.exception.RequestCommonException;
import com.yt.design.jpa.entity.YtTbSiteCommonTypeEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.service.YtTbSiteCommonTypeEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2100118-10014-12 上午9:21001
 **/

@Api(value = "/font/site/api/common/type", tags = "5.分类管理", description = "分类管理")
@RestController
@RequestMapping("/font/site/api/common/type")

public class YtTbSiteCommonTypeController {

    @Autowired
    YtTbSiteCommonTypeEntityService ytTbSiteCommonTypeEntityService;


    @ApiOperation(value = "分页查询", notes = "分页查询<T>")
    @PostMapping(value = "/find/pages")
    public JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>>> findPages(@RequestBody DbDataCommonPageQueryEntity<YtTbSiteCommonTypeEntity> input) {
        JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>>> responseEntity = new JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteCommonTypeEntity>>>
                (JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                        .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(ytTbSiteCommonTypeEntityService.findPages(input));
        } catch (Exception e) {
            responseEntity.setCode(JsonResponseStatus.CODE_SERER_HANDLE_FAILED);
            if (e.getMessage() != null) {
                responseEntity.setMsg(e.getMessage());
            } else {
                responseEntity.setMsg(JsonResponseStatus.MSG_SERER_HANDLE_FAILED);
            }
        }
        return responseEntity;
    }

    @ApiOperation(value = "不分页查询", notes = "不分页查询<T>")
    @PostMapping(value = "/find/all/by/level")
    public JsonResponseEntity<List<YtTbSiteCommonTypeEntity>> findWithOutPages(@RequestBody YtTbSiteCommonTypeEntity input) {
        JsonResponseEntity<List<YtTbSiteCommonTypeEntity>> responseEntity = new JsonResponseEntity<List<YtTbSiteCommonTypeEntity>>
                (JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                        .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(ytTbSiteCommonTypeEntityService.findAllByLevel(input));
        } catch (Exception e) {
            responseEntity.setCode(JsonResponseStatus.CODE_SERER_HANDLE_FAILED);
            if (e.getMessage() != null) {
                responseEntity.setMsg(e.getMessage());
            } else {
                responseEntity.setMsg(JsonResponseStatus.MSG_SERER_HANDLE_FAILED);
            }
        }
        return responseEntity;
    }
}
