package com.yitengtech.handler;

import java.io.IOException;

import com.yitengtech.bean.Position;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/*
 * 用于对网络事件进行读写操作
 */
public class TCPTestHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead (ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf buf = (ByteBuf) msg;
		byte[] req = new byte[buf.readableBytes()];
		buf.readBytes(req);
		String body = new String(req, "utf-8");
		System.out.println("The time server receive : " + body);
		
		byte[] rep = new Position().toString().getBytes();		//应答消息
		ctx.writeAndFlush(Unpooled.copiedBuffer(rep));			//异步发送应答消息
		
	}
	
	public void channelReadComplete(ChannelHandlerContext ctx) {
		ctx.flush();	//将缓冲区的消息全部写入SocketChannel
	}
	
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		ctx.close();
	}
}
