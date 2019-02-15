/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author fuyang
 * @version $Id: ChannelHandlerSample.java, v 0.1 2019年02月14日 4:09 PM fuyang Exp $
 */
public class ChannelHandlerSample extends ChannelInboundHandlerAdapter {

    private int count;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ByteBuf byteBuf = (ByteBuf) msg;
        //byte[] data = new byte[byteBuf.readableBytes()];
        //byteBuf.readBytes(data);
        System.out.println("resquest:" + msg + ",count=" + ++count);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}