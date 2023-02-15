package com.xiaozhuanglt.mitutucue.springboot.controller;


import com.xiaozhuanglt.mitutucue.springboot.service.interfaces.AmapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
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
    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    AmapService amapService;

    @GetMapping("consumerDemo")
    public String queryMitutucueArea() {
        try {
            System.out.println("=========1:"+MDC.get("traceId"));
            logger.info("开始查询 muitutucueArea:");
            logger.error("开始查询 muitutucueArea:");
            int i = amapService.queryMitutucueArea(Long.valueOf(5));
            System.out.println("=========2:"+MDC.get("traceId"));
            logger.info("查询muitutucueArea 结束:");
            return String.valueOf(MDC.get("traceId"));
        }catch (Exception e){
            logger.error("查询mitutucueArea错误:",e);
            System.out.println(e);
            return String.valueOf(MDC.get("traceId"));
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
