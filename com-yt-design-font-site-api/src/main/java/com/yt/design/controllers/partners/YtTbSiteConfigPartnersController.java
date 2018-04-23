package com.yt.design.controllers.partners;

import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.jpa.entity.YtTbSiteConfigPartnersEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.service.YtTbSiteConfigPartnersEntityService;
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

@Api(value = "/font/site/api/partners", tags = "8.合作伙伴", description = "合作伙伴")
@RestController
@RequestMapping("/font/site/api/partners")

public class YtTbSiteConfigPartnersController {

    @Autowired
    YtTbSiteConfigPartnersEntityService entityService;

    @ApiOperation(value = "分页查询", notes = "分页查询<T>")
    @PostMapping(value = "/find/pages")
    public JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigPartnersEntity>>> findPages(@RequestBody DbDataCommonPageQueryEntity<YtTbSiteConfigPartnersEntity> input) {
        JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigPartnersEntity>>> responseEntity = new JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigPartnersEntity>>>
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
    public JsonResponseEntity<List<YtTbSiteConfigPartnersEntity>> findWithOutPages(@RequestBody YtTbSiteConfigPartnersEntity input) {
        JsonResponseEntity<List<YtTbSiteConfigPartnersEntity>> responseEntity = new JsonResponseEntity<List<YtTbSiteConfigPartnersEntity>>
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
