package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * UDP ��������
 * ʵ�ֶ�ν��տͻ������ݣ���ʾ���ݲ�����
 */
public class MulUDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket receiveDP = null;
		
		int port = 10000;
		byte[] data = new byte[1024];
		
		try {
			ds = new DatagramSocket(port);
			
			System.out.println("������������");
			
			while(true) {
				receiveDP = new DatagramPacket(data, data.length);
				
				ds.receive(receiveDP);
				
				new LogicThread(receiveDP,ds);
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
