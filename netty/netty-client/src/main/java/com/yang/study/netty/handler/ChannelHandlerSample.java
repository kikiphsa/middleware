/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.netty.handler;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author fuyang
 * @version $Id: ChannelHandlerSample.java, v 0.1 2019年02月14日 4:09 PM fuyang Exp $
 */
public class ChannelHandlerSample extends ChannelInboundHandlerAdapter {

    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 100; i++) {
            List<String> list = new ArrayList<>();
            list.add("" + i);
            ctx.write(list);
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ByteBuf byteBuf = (ByteBuf) msg;
        //byte[] data = new byte[byteBuf.readableBytes()];
        //byteBuf.readBytes(data);
        System.out.println("response:" + msg + ",count=" + ++count);
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}