package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP �ͻ���
 * ����socket���ӣ�ʹ��һ��socket���ӷ�����������
 */
public class MulSocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;					//������
		OutputStream os = null;					//�����
		
		//��������IP��ַ
		String serverIP = "127.0.0.1";
		
		//�������˿ں�
		int port = 10000;
		
		//��Ҫ���͵�����
		String[] data = {"First","Second","Third"};
		
		try {
			socket = new Socket(serverIP, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			byte[] b = new byte[1024];
			
			for (int i = 0; i < data.length; i++) {
				os.write(data[i].getBytes());
				
				int len = is.read(b);
				System.out.println("���շ�����"+new String(b, 0, len));
			}
			socket.shutdownOutput();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				is.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
