package com.yt.design.controllers.Ads;

import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.jpa.entity.YtTbSiteConfigAdsEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.service.YtTbSiteConfigAdsEntityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description a
 * @Author
 * @Create 2100118-10014-12 上午9:21001
 **/

@Api(value = "/font/site/api/asd", tags = "4.轮播广告", description = "轮播广告")
@RestController
@RequestMapping("/font/site/api/asd")

public class YtTbSiteConfigAdsController {

    @Autowired
    YtTbSiteConfigAdsEntityService entityService;

    @ApiOperation(value = "分页查询", notes = "分页查询<T>")
    @PostMapping(value = "/find/pages")
    public JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigAdsEntity>>> findPages(@RequestBody DbDataCommonPageQueryEntity<YtTbSiteConfigAdsEntity> input) {
        JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigAdsEntity>>> responseEntity = new JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigAdsEntity>>>
                (JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                        .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.findPages(input));
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
    @PostMapping(value = "/find/all")
    public JsonResponseEntity<List<YtTbSiteConfigAdsEntity>> findWithOutPages(@RequestBody YtTbSiteConfigAdsEntity input) {
        JsonResponseEntity<List<YtTbSiteConfigAdsEntity>> responseEntity = new JsonResponseEntity<List<YtTbSiteConfigAdsEntity>>
                (JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                        .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.findAll(null));
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
