/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.integration;

import com.xiaozhuanglt.mitutucue.facade.DemoFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.samples.api.GreetingService;
import org.springframework.stereotype.Component;

/**
 * @author hxz（Eason）
 * @version $Id: AmapServiceConsummer.java, v 0.1 2023-01-04 17:38 hxz（Eason） Exp $$
 */
@Component
public class AmapServiceConsummer {

    @DubboReference(version = "1.0.0",group = "dubbo")
    DemoFacade demoFacade;

    @DubboReference(version = "1.0.0")
    private GreetingService greetingService;

    public int queryMitutucueArea(Long areaId) {
        int i = 0;
        i = demoFacade.queryArea(areaId);
        return i;
    }

    public String doSayHello(String name) {
        return greetingService.sayHello(name);
    }
}