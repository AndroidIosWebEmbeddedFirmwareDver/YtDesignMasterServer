package com.yt.design.controllers.files;

import com.yt.design.entity.common.JsonResponseEntity;
import com.yt.design.entity.common.JsonResponseStatus;
import com.yt.design.jpa.entity.YtTbSiteConfigFilesCenterEntity;
import com.yt.design.jpa.service.YtTbSiteConfigFilesCenterEntityService;
import com.yt.design.utils.DateUtil;
import com.yt.design.utils.UuidUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Objects;


/**
 * @Description a
 * @Author
 * @Create 2018-04-12 上午9:20
 **/

@Api(value = "/site/file/cenetr/api/download", tags = "2.文件下载", description = "文件下载")
@RestController
@RequestMapping("/site/file/cenetr/api/download")

public class YtFileCenterFileDownloadController {

    @Autowired
    YtTbSiteConfigFilesCenterEntityService entityService;


    @ApiOperation(value = "文件下载", notes = "文件下载<T>")
    @RequestMapping(value = "/getFile", method = RequestMethod.GET)
    public JsonResponseEntity fileDownload(@RequestParam("uid") String fileUid, HttpServletRequest request, HttpServletResponse response) {
        JsonResponseEntity responseEntity = new JsonResponseEntity(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            //1.工具UID查询记录
            YtTbSiteConfigFilesCenterEntity entity = entityService.findOneByFileUid(fileUid);

            if (entity != null && entity.getFilePaths() != null && entity.getFilePaths().length() > 0) {
                //-------------------------------------
                System.out.println("文件存放目录：" + entity.getFilePaths());
                System.out.println("文件名称：" + entity.getFileName());
                //-------------------------------------
                //设置响应头，控制浏览器下载该文件
                response.setContentType("application/octet-stream; charset=utf-8");
                response.setHeader("Content-Disposition", "attachment; filename=" + entity.getFileName());

                //读取要下载的文件，保存到文件输入流
                FileInputStream in = new FileInputStream(entity.getFilePaths());
                //创建输出流
                OutputStream out = response.getOutputStream();
                //创建缓冲区
                byte buffer[] = new byte[1024 * 1024];
                int len = 0;
                //循环将输入流中的内容读取到缓冲区当中
                while ((len = in.read(buffer)) > 0) {
                    //输出缓冲区的内容到浏览器，实现文件下载
                    out.write(buffer, 0, len);
                }
                //关闭文件输入流
                in.close();
                //关闭输出流
                out.close();
            } else {
                responseEntity.setCode(JsonResponseStatus.CODE_SERER_HANDLE_FAILED);
                responseEntity.setMsg("UID对应文件不存在");
            }

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
