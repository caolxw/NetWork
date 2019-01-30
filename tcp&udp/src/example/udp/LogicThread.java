package example.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class LogicThread extends Thread {
	private DatagramPacket receiveDP;
	private DatagramSocket ds;
	private static int id = 0;
	
	public LogicThread(DatagramPacket receiveDP, DatagramSocket ds) {
		super();
		this.receiveDP = receiveDP;
		this.ds = ds;
		id ++;
		start(); 		//�����߳�
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			byte[] data = receiveDP.getData();
			int len = receiveDP.getLength();
			InetAddress clientIP = receiveDP.getAddress();
			int port = receiveDP.getPort();
			
			System.out.println("�ͻ���IP��ַ��" + clientIP);
			System.out.println("�ͻ��˶˿ںţ�" + port);
			System.out.println("�ͻ������ݣ�" + new String(data, 0, len));
			
			String redata = "OK " + id;
			byte[] b = redata.getBytes();
			
			DatagramPacket sendDp = new DatagramPacket(b, b.length, clientIP, port);
			ds.send(sendDp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
}
