package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP ��������
 * ���տͻ��˵����ݲ�������Ϣ
 */
public class MulSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		int port = 10000;
		try {
			ss = new ServerSocket(port);
			
			socket = ss.accept();
			is = socket.getInputStream();
			os = socket.getOutputStream();
			byte[] b = new byte[1024];
			int len;
			
			while ((len = is.read(b)) != -1) {
				System.out.println("���յ��ͻ������ݣ�"+new String(b, 0, len));
				
				String data = new String(b, 0, len) + " ACK";
				os.write(data.getBytes());
			}
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
