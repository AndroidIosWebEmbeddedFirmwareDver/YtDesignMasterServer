package com.yt.design.controllers;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yt.design.entity.RestMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description a
 * @Author
 * @Create 2018-04-03 下午8:37
 **/
@Api(value = "测试文件上传", tags = "98.测试文件上传")
@Controller
@RequestMapping("/api/upload")
public class TestUploadController {

    @ApiOperation(value = "文件素材上传接口")
    @ApiImplicitParams({@ApiImplicitParam(name = "file", value = "文件流对象,接收数组格式", required = true, dataType = "MultipartFile"),
            @ApiImplicitParam(name = "title", value = "title", required = true)}
    )
    @RequestMapping(value = "/uploadMaterial", method = RequestMethod.POST)
    @ResponseBody
    public RestMessage uploadMaterial(@RequestParam(value = "file") MultipartFile[] files, @RequestParam(value = "title") String title, HttpServletRequest request) throws IOException {
        //int mul=1*1024*1024;
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
        File realFile = new File(realPath);
        if (!realFile.exists()) {
            realFile.mkdirs();
        }
        List<Map> uploadFiles = Lists.newArrayList();
        System.out.println("进入图片上传接口:" + files.length + "张");
        for (MultipartFile file : files) {
            File targetFile = new File(realFile, file.getOriginalFilename());
            FileOutputStream fileOutputStream = null;
            InputStream ins = null;
            try {
                fileOutputStream = new FileOutputStream(targetFile);
                int i = -1;
                byte[] bytes = new byte[1024 * 1024];
                ins = file.getInputStream();
                while ((i = ins.read(bytes)) != -1) {
                    fileOutputStream.write(bytes, 0, i);
                }
            } catch (IOException ignored) {

            } finally {
                closeQuilty(ins);
                closeQuilty(fileOutputStream);
            }
            Map fileInfo = Maps.newHashMap();
            fileInfo.put("id", UUID.randomUUID().toString());
            fileInfo.put("url", targetFile.getPath());
            fileInfo.put("original_name", targetFile.getName());
            uploadFiles.add(fileInfo);
        }
        RestMessage rm = new RestMessage();
        rm.setData(uploadFiles);
        return rm;
    }


    private void closeQuilty(InputStream ins) {
        if (ins != null) {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void closeQuilty(OutputStream out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}