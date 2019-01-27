package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/*
 * UDP 客户端
 *	 向服务器端发送多次系统时间
 */
public class MulUDPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket sendDP = null;
		DatagramPacket receiveDP = null;
		
		String serverIP = "127.0.0.1";
		final int port = 10000;
		
		try {
			ds = new DatagramSocket();
			
			for (int i = 0; i < 10; i++) {
				String time = new Date().toString();
				byte[] data = time.getBytes();
				InetAddress address = InetAddress.getByName(serverIP);
				sendDP = new DatagramPacket(data,data.length,address,port);
				
				ds.send(sendDP);
				
				byte[] redata = new byte[1024];
				receiveDP = new DatagramPacket(redata, redata.length);
				
				ds.receive(receiveDP);
				
				byte[] b = receiveDP.getData();
				int len = receiveDP.getLength();
				System.out.println("服务器返回数据：" + new String(b,0,len));
				
				Thread.sleep(1000);
			}
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
