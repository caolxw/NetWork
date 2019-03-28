package com.yitengtech.service;

import com.yitengtech.handler.TCPTestHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TCPNettyServer {

	public void bind(int port) {
		//���÷������˵�NIO�߳���
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		ServerBootstrap b = new ServerBootstrap();				//����NIO����˵ĸ���������
		b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.childHandler(new ChannelInitializer<SocketChannel>() {	//IO�¼��Ĵ�����

				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					// TODO Auto-generated method stub
					ch.pipeline().addLast(new TCPTestHandler());
				}
				
			});
		try {
			//�󶨶˿ڣ�ͬ���ȴ��ɹ�
			ChannelFuture future = b.bind(port).sync();
			//�ȴ�����˼����˿ڹر�
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {}
		finally {
			//�˳����ͷ��߳�����Դ
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
		}
		new TCPNettyServer().bind(port);
	}

}
