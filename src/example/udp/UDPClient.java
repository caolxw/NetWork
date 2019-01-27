package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

/*
 * UDP �ͻ���
 * ��������˷���ϵͳʱ��
 */
public class UDPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket ds = null;
		DatagramPacket sendDP = null;		//�������ݰ�
		DatagramPacket receiveDP = null;	//�������ݰ�
		
		String receiveIP = "127.0.0.1";
		int port = 10000;
		
		try {
			//��������
			ds = new DatagramSocket();
			
			//��ʼ������
			String data = new Date().toString();
			byte[] b = data.getBytes();
			
			//��ʼ�����Ͱ�����
			InetAddress address = InetAddress.getByName(receiveIP);
			sendDP = new DatagramPacket(b, b.length, address, port);
			
			//�������ݰ�
			ds.send(sendDP);
			
			//��ʼ����������
			byte[] b2 = new byte[1024];
			receiveDP = new DatagramPacket(b2, b2.length);
			
			//��������
			ds.receive(receiveDP);
			
			//��������
			byte[] redata = receiveDP.getData();		//��û�������
			int len = receiveDP.getLength();			//��Ч���ݳ���
			System.out.println("����������Ϊ��" + new String(redata, 0, len));
			
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
