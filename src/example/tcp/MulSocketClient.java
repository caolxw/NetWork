package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP 客户端
 * 复用socket连接，使用一个socket连接发送三次数据
 */
public class MulSocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;					//输入流
		OutputStream os = null;					//输出流
		
		//服务器的IP地址
		String serverIP = "127.0.0.1";
		
		//服务器端口号
		int port = 10000;
		
		//需要发送的数据
		String[] data = {"First","Second","Third"};
		
		try {
			socket = new Socket(serverIP, port);
			is = socket.getInputStream();
			os = socket.getOutputStream();
			byte[] b = new byte[1024];
			
			for (int i = 0; i < data.length; i++) {
				os.write(data[i].getBytes());
				
				int len = is.read(b);
				System.out.println("接收反馈："+new String(b, 0, len));
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
