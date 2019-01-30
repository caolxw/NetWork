package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP �ͻ���
 * 
 * ����"Hello"���������ˣ�����ӡ���������˵ķ���
 */
public class SocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;					//������
		OutputStream os = null;					//�����
		
		//��������IP��ַ
		String serverIP = "127.0.0.1";
		
		//�������˿ں�
		int port = 10000;
		
		//��Ҫ���͵�����
		String data = "Hello";
		
		try {
			//�������� ʵ��Ϊ����һ��socket����
			socket = new Socket(serverIP, port);
			
			//��������
			os = socket.getOutputStream();
			os.write(data.getBytes());
			
			
			//��������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int len = is.read(b);
			
			//��ӡ������
			System.out.println("�������ķ�����" + new String(b, 0, len));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				//�ر���������
				is.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
