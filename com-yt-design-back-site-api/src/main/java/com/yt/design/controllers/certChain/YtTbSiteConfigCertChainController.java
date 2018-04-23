package com.yt.design.controllers.certChain;

import com.yt.design.controllers.common.YtTbFontSiteCommonController;
import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.jpa.entity.YtTbSiteConfigCertChainEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.service.YtTbSiteConfigCertChainEntityService;
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
 * @Create 2018-04-12 上午9:20
 **/

@Api(value = "/back/site/api/cert/chain/config", tags = "10.证书模板管理", description = "证书模板管理")
@RestController
@RequestMapping("/back/site/api/cert/chain/config")

public class YtTbSiteConfigCertChainController implements YtTbFontSiteCommonController<YtTbSiteConfigCertChainEntity> {

    @Autowired
    YtTbSiteConfigCertChainEntityService entityService;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "新增", notes = "新增<T>")
    @PostMapping(value = "/create")
    @Override
    public JsonResponseEntity<YtTbSiteConfigCertChainEntity> create(@RequestBody YtTbSiteConfigCertChainEntity input) {
        JsonResponseEntity<YtTbSiteConfigCertChainEntity> responseEntity = new JsonResponseEntity<YtTbSiteConfigCertChainEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.create(input));
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

    /**
     * 删除
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "删除", notes = "删除<T>")
    @PostMapping(value = "/delete")
    @Override
    public JsonResponseEntity<YtTbSiteConfigCertChainEntity> delete(@RequestBody YtTbSiteConfigCertChainEntity input) {
        JsonResponseEntity<YtTbSiteConfigCertChainEntity> responseEntity = new JsonResponseEntity<YtTbSiteConfigCertChainEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.delete(input));
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

    /**
     * 修改
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "修改", notes = "修改<T>")
    @PostMapping(value = "/update")
    @Override
    public JsonResponseEntity<YtTbSiteConfigCertChainEntity> update(@RequestBody YtTbSiteConfigCertChainEntity input) {
        JsonResponseEntity<YtTbSiteConfigCertChainEntity> responseEntity = new JsonResponseEntity<YtTbSiteConfigCertChainEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.update(input));
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

    /**
     * 查询一条
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "查询一条", notes = "查询一条<T>")
    @PostMapping(value = "/findOne")
    @Override
    public JsonResponseEntity<YtTbSiteConfigCertChainEntity> findOne(@RequestBody YtTbSiteConfigCertChainEntity input) {
        JsonResponseEntity<YtTbSiteConfigCertChainEntity> responseEntity = new JsonResponseEntity<YtTbSiteConfigCertChainEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.findOne(input));
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

    /**
     * 查询一堆
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "查询一堆", notes = "查询一堆<T>")
    @PostMapping(value = "/find")
    @Override
    public JsonResponseEntity<List<YtTbSiteConfigCertChainEntity>> find(@RequestBody YtTbSiteConfigCertChainEntity input) {
        JsonResponseEntity<List<YtTbSiteConfigCertChainEntity>> responseEntity = new JsonResponseEntity<List<YtTbSiteConfigCertChainEntity>>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS,
                JsonResponseStatus
                        .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(entityService.find(input));
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

    /**
     * 查询一堆分页数据
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "查询一堆分页数据", notes = "查询一堆分页数据<T>")
    @PostMapping(value = "/findPages")
    @Override
    public JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigCertChainEntity>>> findPages(@RequestBody DbDataCommonPageQueryEntity<YtTbSiteConfigCertChainEntity> input) {
        JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigCertChainEntity>>> responseEntity = new JsonResponseEntity<DbDataCommonPageDownEntity<List<YtTbSiteConfigCertChainEntity>>>
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
}
