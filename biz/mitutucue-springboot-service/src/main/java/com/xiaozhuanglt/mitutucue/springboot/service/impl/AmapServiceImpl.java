package com.xiaozhuanglt.mitutucue.springboot.service.impl;

import com.xiaozhuanglt.mitutucue.springboot.integration.AmapServiceConsummer;
import com.xiaozhuanglt.mitutucue.springboot.service.interfaces.AmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 框架测试AmapService
 * @author: hxz
 * @create: 2019-05-09 18:06
 **/
@Service("amapService")
public class AmapServiceImpl implements AmapService {

    @Autowired
    AmapServiceConsummer amapServiceConsummer;

    /**
     * @param areaId
     * @return {@link Long}
     * @author hxz
     * @date 2019/5/17 18:00
     * @Description: Dubbo框架测试
     * @Param: [areaId]
     */
    @Override
    public int queryMitutucueArea(Long areaId) {
        int i = 0;
        i = amapServiceConsummer.queryMitutucueArea(areaId);
        return i;
    }
}
