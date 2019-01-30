package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP 服务器端
 * 接收客户端发送的内容并反馈
 */
public class SocketServer {
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		
		//监听端口号
		int port = 10000;
		try {
			//监听端口
			ss = new ServerSocket(port);
			
			//获得连接
			socket = ss.accept();
			
			//接收客户端数据
			is = socket.getInputStream();
			byte[] b = new byte[1024];
			int len = is.read(b);
			
			System.out.println("客户端发送数据：" + new String(b, 0, len));
			
			//反馈信息
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
