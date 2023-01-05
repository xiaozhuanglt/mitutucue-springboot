/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.integration;

import com.xiaozhuanglt.mitutucue.facade.DemoFacade;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author hxz（Eason）
 * @version $Id: AmapServiceConsummer.java, v 0.1 2023-01-04 17:38 hxz（Eason） Exp $$
 */
@Service("amapServiceConsummer")
public class AmapServiceConsummer {

    @DubboReference
    DemoFacade demoFacade;

    public int queryMitutucueArea(Long areaId) {
        int i = 0;
        i = demoFacade.queryArea(areaId);
        return i;
    }
}