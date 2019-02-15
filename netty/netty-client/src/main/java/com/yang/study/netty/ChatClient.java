/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.yang.study.netty;

import com.yang.study.netty.handler.ChannelHandlerSample;
import com.yang.study.netty.handler.MessagePackDecoder;
import com.yang.study.netty.handler.MessagePackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author fuyang
 * @version $Id: ChatClient.java, v 0.1 2019年02月14日 4:57 PM fuyang Exp $
 */
public class ChatClient {

    private String address;

    private int port;

    public void connect() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(
                new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //ch.pipeline().addLast(new FixedLengthFrameDecoder(3));
                        //ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535,0,2,0,2));
                        ch.pipeline().addLast(new MessagePackDecoder());
                        ch.pipeline().addLast(new LengthFieldPrepender(2));
                        ch.pipeline().addLast(new MessagePackEncoder());
                        ch.pipeline().addLast(new ChannelHandlerSample());
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect(address, port).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    /**
     * Setter method for property <tt>address</tt>.
     *
     * @param address value to be assigned to property address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Setter method for property <tt>port</tt>.
     *
     * @param port value to be assigned to property port
     */
    public void setPort(int port) {
        this.port = port;
    }
}