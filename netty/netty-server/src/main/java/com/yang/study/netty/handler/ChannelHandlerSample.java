/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.netty.handler;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author fuyang
 * @version $Id: ChannelHandlerSample.java, v 0.1 2019年02月14日 4:09 PM fuyang Exp $
 */
public class ChannelHandlerSample extends ChannelInboundHandlerAdapter {

    private static final ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    private static final Map<String, String> userNamesMap = new HashMap<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        channelGroup.add(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        String name = userNamesMap.get(ctx.channel().remoteAddress().toString());
        System.out.println("【" + name + "】离开群聊");
        channelGroup.remove(ctx.channel());
        userNamesMap.remove(ctx.channel().remoteAddress().toString());
        for (Channel channel : channelGroup) {
            channel.writeAndFlush("【" + name + "】离开群聊");
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] data = ((String) msg).split(":");
        if (data.length == 1) {
            for (Channel channel : channelGroup) {
                if (channel != ctx.channel()) {
                    channel.writeAndFlush("【" + userNamesMap.get(ctx.channel().remoteAddress().toString()) + "】:" + msg);
                } else {
                    channel.writeAndFlush("【我】:" + msg);
                }
            }
        } else {
            userNamesMap.put(ctx.channel().remoteAddress().toString(), data[1]);
            System.out.println("【" + data[1] + "】加入群聊");
            for (Channel channel : channelGroup) {
                if (channel != ctx.channel()) {
                    channel.writeAndFlush("【" + data[1] + "】加入群聊");
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}