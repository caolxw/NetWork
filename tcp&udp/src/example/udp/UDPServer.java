package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP 服务器端
 * 接收客户端的数据包，并反馈
 */
public class UDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket receiveDP = null;
		DatagramPacket sendDP = null;
		
		final int port = 10000;
		
		try {
			//建立连接并监听窗口
			ds = new DatagramSocket(port);
			
			//初始化接收数据
			byte[] b = new byte[1024];
			receiveDP = new DatagramPacket(b, b.length);
			
			//接收数据
			ds.receive(receiveDP);
			
			//处理数据
			InetAddress clientIP = receiveDP.getAddress();		//获得客户端IP地址
			int clientPort = receiveDP.getPort();				//获得客户端端口号
			byte[] reb = receiveDP.getData();
			int len = receiveDP.getLength();
			
			System.out.println("客户端IP：" + clientIP);
			System.out.println("客户端端口号：" + clientPort);
			System.out.println("客户端数据：" + new String(reb, 0, len));
			
			//初始化发送数据包
			byte[] sendb = "OK".getBytes();
			sendDP = new DatagramPacket(sendb, sendb.length, clientIP, clientPort);
			
			//发送数据
			ds.send(sendDP);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ds.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
