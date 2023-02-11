/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2023 All Rights Reserved.
 */
package com.xiaozhuanglt.mitutucue.springboot.web.config;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.RpcServiceContext;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author hxz（Eason）
 * @version $Id: TraceIdFilter.java, v 0.1 2023-01-16 00:16 hxz（Eason） Exp $$
 */
@Activate(group = {CommonConstants.CONSUMER_SIDE,CommonConstants.PROVIDER_SIDE})
public class TraceIdFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcServiceContext rpcServiceContext = RpcContext.getServiceContext();

        String traceId;
        if (null == rpcServiceContext.getUrl()){
            return invoker.invoke(invocation);
        }
        if (rpcServiceContext.isConsumerSide()) {
            traceId = MDC.get("traceId");
            traceId = rpcServiceContext.getAttachment("traceId");
            if (traceId == null) {
                traceId = UUID.randomUUID().toString();
                rpcServiceContext.setAttachment("traceId",traceId);
            }
            String traceId1 = MDC.get("traceId");
            MDC.put("traceId", traceId);


        }
        if (rpcServiceContext.isProviderSide()) {
            traceId = rpcServiceContext.getAttachment("traceId");
            if (traceId == null) {
                traceId = UUID.randomUUID().toString();
                rpcServiceContext.setAttachment("traceId",traceId);
            }
            MDC.put("traceId", traceId);
        }
        return invoker.invoke(invocation);
    }
}
