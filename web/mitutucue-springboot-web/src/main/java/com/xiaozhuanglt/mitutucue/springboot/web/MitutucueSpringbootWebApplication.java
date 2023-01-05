package com.xiaozhuanglt.mitutucue.springboot.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozhuanglt.mitutucue.springboot"})
@EnableDubbo(scanBasePackages = "com.xiaozhuanglt.mitutucue.springboot")
public class MitutucueSpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MitutucueSpringbootWebApplication.class, args);
    }

}
