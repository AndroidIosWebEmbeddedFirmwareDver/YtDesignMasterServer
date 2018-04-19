package com.yt.design.controllers;

import com.yt.design.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午11:13
 **/
@Api(value = "test", tags = "99.测试接口", description = "一组测试api")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "获取随机字符串", notes = "根据传入字符串长度随机返回字符串")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
//            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
//    })


    @GetMapping(value = "/randomStr")
    public String getRandom(@RequestParam(defaultValue = "100") int strLen) {
        return RandomUtil.getRandomString(strLen);
    }

    @ApiOperation(value = "获取随机字符串", notes = "根据传入字符串长度随机返回字符串")
    @GetMapping(value = "/v1/randomStr")
    public String getRandom1(@RequestParam(defaultValue = "100") int strLen) {
        return RandomUtil.getRandomString(strLen);
    }

    @ApiOperation(value = "获取随机字符串", notes = "根据传入字符串长度随机返回字符串")
    @GetMapping(value = "/v2/randomStr")
    public String getRandom2(@RequestParam(defaultValue = "100") int strLen) {
        return RandomUtil.getRandomString(strLen);
    }

    @ApiOperation(value = "获取随机字符串", notes = "根据传入字符串长度随机返回字符串")
    @GetMapping(value = "/v3/randomStr")
    public String getRandom3(@RequestParam(defaultValue = "100") int strLen) {
        return RandomUtil.getRandomString(strLen);
    }

    @ApiOperation(value = "获取随机字符串", notes = "根据传入字符串长度随机返回字符串")
    @GetMapping(value = "/v4/randomStr")
    public String getRandom4(@RequestParam(defaultValue = "100") int strLen) {
        return RandomUtil.getRandomString(strLen);
    }


}
