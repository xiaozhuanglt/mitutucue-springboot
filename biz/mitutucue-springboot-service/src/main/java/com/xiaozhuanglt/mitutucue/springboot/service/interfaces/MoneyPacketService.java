/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hxz（Eason）
 * @version $Id: MoneyPacketService.java, v 0.1 2023-03-13 16:27 hxz（Eason） Exp $$
 */
public interface MoneyPacketService {

    /**
     * 随机分配红包金额
     */
    List<BigDecimal> claim(int receiverCount);
}
