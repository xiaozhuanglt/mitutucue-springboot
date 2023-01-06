package com.xiaozhuanglt.mitutucue.springboot.web;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.xiaozhuanglt.mitutucue.springboot"})
@EnableDubbo(scanBasePackages = "com.xiaozhuanglt.mitutucue.springboot")
//@PropertySource("classpath:/dubbo-consumer.properties")
//@ImportResource({"classpath:/dubbo-demo-consumer.xml"})
public class MitutucueSpringbootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MitutucueSpringbootWebApplication.class, args);
    }

}
