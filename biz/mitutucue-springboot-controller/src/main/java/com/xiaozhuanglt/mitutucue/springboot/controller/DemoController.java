package com.xiaozhuanglt.mitutucue.springboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: springboot框架测试
 * @author: hxz
 * @create: 2019-05-10 15:02
 **/

@RestController
@RequestMapping("/demoController")
public class DemoController {

    @GetMapping("consumerDemo")
    public int queryMitutucueArea() {
        return Integer.valueOf(5);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
