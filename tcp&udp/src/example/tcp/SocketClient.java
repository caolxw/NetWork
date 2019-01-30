package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * TCP 客户端
 * 
 * 发送"Hello"到服务器端，并打印出服务器端的反馈
 */
public class SocketClient {
	public static void main(String[] args) {
		Socket socket = null;
		InputStream is = null;					//输入流
		OutputStream os = null;					//输出流
		
		//服务器的IP地址
		String serverIP = "127.0.0.1";
		
		//服务器端口号
		int port = 10000;
		
		//需要发送的数据
		String data = "Hello";
		
		try {
			//建立连接 实则为创建一个socket对象
			socket = new Socket(serverIP, port);
			
			//发送数据
			os = socket.getOutputStream();
			os.write(data.getBytes());
			
			
			//接收数据
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int len = is.read(b);
			
			//打印出反馈
			System.out.println("服务器的反馈：" + new String(b, 0, len));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				//关闭流和连接
				is.close();
				os.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
