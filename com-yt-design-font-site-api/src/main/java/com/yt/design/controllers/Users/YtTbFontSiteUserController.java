package com.yt.design.controllers.Users;

import com.yt.design.controllers.common.YtTbFontSiteCommonController;
import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.exception.JpaCommonException;
import com.yt.design.jpa.entity.YtTbFontSiteUserEntity;
import com.yt.design.jpa.entity.YtTbFontSiteUserEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageDownEntity;
import com.yt.design.jpa.entity.common.DbDataCommonPageQueryEntity;
import com.yt.design.jpa.service.YtTbFontSiteUserEntityService;
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

@Api(value = "/back/site/api/user", tags = "6.用户管理", description = "用户管理")
@RestController
@RequestMapping("/back/site/api/user")

public class YtTbFontSiteUserController {

    @Autowired
    YtTbFontSiteUserEntityService ytTbFontSiteUserEntityService;


    /**
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "注册", notes = "注册一个用户<T>")
    @PostMapping(value = "/create")
    public JsonResponseEntity<YtTbFontSiteUserEntity> fontSiteCreate(@RequestBody YtTbFontSiteUserEntity input) {
        JsonResponseEntity<YtTbFontSiteUserEntity> responseEntity = new JsonResponseEntity<YtTbFontSiteUserEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(ytTbFontSiteUserEntityService.fontSiteCreate(input));
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
     * 新增
     *
     * @param input 输入参数
     * @return 输出参数
     */
    @ApiOperation(value = "登录", notes = "使用一个邮箱登录<T>")
    @PostMapping(value = "/login")
    public JsonResponseEntity<YtTbFontSiteUserEntity> fontSiteLogin(@RequestBody YtTbFontSiteUserEntity input) {
        JsonResponseEntity<YtTbFontSiteUserEntity> responseEntity = new JsonResponseEntity<YtTbFontSiteUserEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            responseEntity.setData(ytTbFontSiteUserEntityService.fontSiteLogin(input));
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
