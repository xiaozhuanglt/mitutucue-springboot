/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author hxz（Eason）
 * @version $Id: SwaggerConfig.java, v 0.1 2023-03-07 19:02 hxz（Eason） Exp $$
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xiaozhuanglt.mitutucue.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("mitutucue-springboot-swagger Api")
                .description("api根地址：http://localhost:8080/")
                .termsOfServiceUrl("https://xiaomo.info/")
                .version("1.0")
                .build();
    }

    /**
     *  swagger 引入对新UI，首页方式改为http://localhost:8081/mitutucue-springboot/doc.html，
     *  原页面链接为：http://localhost:8081/mitutucue-springboot/swagger-ui/index.html
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }

}
