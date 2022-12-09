package com.xiaozhuanglt.mitutucue.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozhuanglt.mitutucue.springboot.controller",
        "com.xiaozhuanglt.mitutucue.springboot.web"})
public class MitutucueSpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MitutucueSpringbootWebApplication.class, args);
    }

}
