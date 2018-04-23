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
import java.io.IOException;
import java.util.Date;
import java.util.Objects;


/**
 * @Description a
 * @Author
 * @Create 2018-04-12 上午9:20
 **/

@Api(value = "/site/file/cenetr/api/upload", tags = "1.文件上传", description = "文件上传")
@RestController
@RequestMapping("/site/file/cenetr/api/upload")

public class YtFileCenterFileUploadController {

    @Autowired
    YtTbSiteConfigFilesCenterEntityService entityService;


    @ApiOperation(value = "文件上传", notes = "文件上传<T>")
    @RequestMapping("/create")
    @ResponseBody
    public JsonResponseEntity<YtTbSiteConfigFilesCenterEntity> fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
        JsonResponseEntity<YtTbSiteConfigFilesCenterEntity> responseEntity = new JsonResponseEntity<YtTbSiteConfigFilesCenterEntity>(JsonResponseStatus.CODE_SERER_HANDLE_SUCCESS, JsonResponseStatus
                .MSG_SERER_HANDLE_SUCCESS);
        try {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                fileName = UuidUtil.randomUuidStr() + fileName.substring(fileName.lastIndexOf("."), fileName.length());
                int size = (int) file.getSize();
                String dirPath = Objects.requireNonNull(ClassUtils.getDefaultClassLoader().getResource("")).getPath();
                dirPath += DateUtil.parseDateToStr(new Date(System.currentTimeMillis()), DateUtil.DATE_FORMAT_YYYYMMDD) + "/";
                //-------------------------------------
                System.out.println("文件存放目录：" + dirPath);
                System.out.println("文件名称：" + fileName);
                //-------------------------------------
                String filePath = dirPath + fileName;
                File dest = new File(filePath);
                try {
                    //1、写入缓存
                    if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                        boolean mkdirResult = dest.getParentFile().mkdir();
                    }
                    file.transferTo(dest); //保存文件
                    //2、写入数据到数据库
                    YtTbSiteConfigFilesCenterEntity filesCenterEntity = new YtTbSiteConfigFilesCenterEntity();
                    filesCenterEntity.setFileName(fileName);
                    filesCenterEntity.setFilePaths(filePath);
                    filesCenterEntity.setFileLinks(filePath);
                    filesCenterEntity.setFileFromIp(request.getRemoteAddr());
                    filesCenterEntity = entityService.create(filesCenterEntity);
                    responseEntity.setData(filesCenterEntity);

//                    //3、删除缓存文件
//                    if (dest.exists() && dest.isFile()) {
//                        dest.delete();
//                    }
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }
            } else {
                responseEntity.setCode(JsonResponseStatus.CODE_SERER_HANDLE_FAILED);
                responseEntity.setMsg(JsonResponseStatus.MSG_SERER_HANDLE_FAILED);
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
