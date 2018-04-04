package com.yt.design.back.site.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description a
 * @Author
 * @Create 2018-04-02 下午11:13
 **/

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/randomStr")
    public String getRandom() {
//
        return "back test :" + System.currentTimeMillis();
    }
}
