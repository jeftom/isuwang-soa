package com.isuwang.dapeng.impl.extionsionImpl;

import com.isuwang.dapeng.core.SoaServiceDefinition;
import com.isuwang.dapeng.impl.handler.RequestProcessor;
import com.isuwang.dapeng.remoting.netty.Dispatcher;
import com.isuwang.dapeng.remoting.netty.SoaMessageProcessor;
import com.isuwang.org.apache.thrift.TException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by lihuimin on 2017/12/8.
 */
public class ThreadDispatcher implements Dispatcher {

    @Override
    public void processRequest(ChannelHandlerContext ctx, SoaMessageProcessor parser, SoaServiceDefinition processor, ByteBuf message) throws TException {
       RequestProcessor.processRequest(ctx,parser,processor,message);
    }
}