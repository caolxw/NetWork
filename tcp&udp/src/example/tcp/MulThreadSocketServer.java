package example.tcp;

import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP ��������
 * ʹ������֧�ֶ���ͻ��˹���
 */
public class MulThreadSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket socket = null;
		
		int port = 10000;
		
		try {
			ss = new ServerSocket(port);
			System.out.println("������������");
			while (true) {
				socket = ss.accept();
				
				//�����߳�
				new LogicThread(socket);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
