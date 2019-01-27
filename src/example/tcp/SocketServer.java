package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP ��������
 * ���տͻ��˷��͵����ݲ�����
 */
public class SocketServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		//�����˿ں�
		int port = 10000;
		try {
			//�����˿�
			ss = new ServerSocket(port);
			
			//�������
			socket = ss.accept();
			
			//���տͻ�������
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int len = is.read(b);
			
			System.out.println("�ͻ��˷������ݣ�" + new String(b, 0, len));
			
			//������Ϣ
			os = socket.getOutputStream();
			os.write("ACK".getBytes());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				is.close();
				os.close();
				socket.close();
				ss.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
