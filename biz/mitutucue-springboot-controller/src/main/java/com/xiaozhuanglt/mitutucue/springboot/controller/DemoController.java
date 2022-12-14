package com.xiaozhuanglt.mitutucue.springboot.controller;


import com.xiaozhuanglt.mitutucue.springboot.service.interfaces.AmapService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    AmapService amapService;

    @GetMapping("consumerDemo")
    public int queryMitutucueArea() {
        try {
            int i = amapService.queryMitutucueArea(Long.valueOf(5));
            return i;
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/doSayHello")
    public String doSayHello(String name) {
        return amapService.doSayHello(name);
    }

}
