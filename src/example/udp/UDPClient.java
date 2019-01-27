package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/*
 * UDP 客户端
 * 向服务器端发送系统时间
 */
public class UDPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket sendDP = null;		//发送数据包
		DatagramPacket receiveDP = null;	//接收数据包
		
		String receiveIP = "127.0.0.1";
		int port = 10000;
		
		try {
			//建立连接
			ds = new DatagramSocket();
			
			//初始化数据
			String data = new Date().toString();
			byte[] b = data.getBytes();
			
			//初始化发送包数据
			InetAddress address = InetAddress.getByName(receiveIP);
			sendDP = new DatagramPacket(b, b.length, address, port);
			
			//发送数据包
			ds.send(sendDP);
			
			//初始化接收数据
			byte[] b2 = new byte[1024];
			receiveDP = new DatagramPacket(b2, b2.length);
			
			//接收数据
			ds.receive(receiveDP);
			
			//处理数据
			byte[] redata = receiveDP.getData();		//获得缓冲数组
			int len = receiveDP.getLength();			//有效数据长度
			System.out.println("服务器反馈为：" + new String(redata, 0, len));
			
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
