/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.service.impl;

import com.xiaozhuanglt.mitutucue.springboot.service.interfaces.MoneyPacketService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hxz（Eason）
 * @version $Id: MoneyPacketServiceImpl.java, v 0.1 2023-03-13 16:28 hxz（Eason） Exp $$
 */
public class MoneyPacketServiceImpl implements MoneyPacketService {
    /**
     * 随机分配红包金额
     *
     * @param receiverCount
     */
    @Override
    public List<BigDecimal> claim(int receiverCount) {
        List<BigDecimal> prizes = new ArrayList<>();

        BigDecimal minClaimAmount = BigDecimal.valueOf(1);
        int multiplier = 3;
        int remainCount = receiverCount;

        BigDecimal fundAmount = BigDecimal.valueOf(20);

        BigDecimal balance = fundAmount.subtract(minClaimAmount.multiply(BigDecimal.valueOf(receiverCount)));
        BigDecimal maxAmount;
        BigDecimal poolAmount;

        for (int i=0 ; i<receiverCount ; i++){
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                if (remainCount == 1) {
                    prizes.add(balance.add(minClaimAmount));
                    break;
                }

                maxAmount = balance.divide(BigDecimal.valueOf(remainCount),BigDecimal.ROUND_CEILING)
                        .multiply(BigDecimal.valueOf(multiplier));
                poolAmount = random(maxAmount);
                if (balance.compareTo(poolAmount) > 0) {
                    prizes.add(poolAmount.add(minClaimAmount));
                    balance = balance.subtract(poolAmount);
                } else {
                    prizes.add(balance.add(minClaimAmount));
                    balance = BigDecimal.ZERO;
                }
            } else {
                prizes.add(minClaimAmount);
                balance = BigDecimal.ZERO;
            }
            remainCount--;
        }
        return prizes;
    }


    private BigDecimal random(BigDecimal maxAmount) {
        BigDecimal randFromDouble = BigDecimal.valueOf(Math.random());
        BigDecimal actualRandomDec = randFromDouble.multiply(maxAmount);
        actualRandomDec = actualRandomDec.setScale(2, BigDecimal.ROUND_DOWN);
        return actualRandomDec;
    }
}
