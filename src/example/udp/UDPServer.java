package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * UDP ��������
 * ���տͻ��˵����ݰ���������
 */
public class UDPServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket receiveDP = null;
		DatagramPacket sendDP = null;
		
		final int port = 10000;
		
		try {
			//�������Ӳ���������
			ds = new DatagramSocket(port);
			
			//��ʼ����������
			byte[] b = new byte[1024];
			receiveDP = new DatagramPacket(b, b.length);
			
			//��������
			ds.receive(receiveDP);
			
			//��������
			InetAddress clientIP = receiveDP.getAddress();		//��ÿͻ���IP��ַ
			int clientPort = receiveDP.getPort();				//��ÿͻ��˶˿ں�
			byte[] reb = receiveDP.getData();
			int len = receiveDP.getLength();
			
			System.out.println("�ͻ���IP��" + clientIP);
			System.out.println("�ͻ��˶˿ںţ�" + clientPort);
			System.out.println("�ͻ������ݣ�" + new String(reb, 0, len));
			
			//��ʼ���������ݰ�
			byte[] sendb = "OK".getBytes();
			sendDP = new DatagramPacket(sendb, sendb.length, clientIP, clientPort);
			
			//��������
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
