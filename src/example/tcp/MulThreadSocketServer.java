package example.tcp;

import java.net.ServerSocket;
import java.net.Socket;

/*
 * TCP 服务器端
 * 使服务器支持多个客户端工作
 */
public class MulThreadSocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket socket = null;
		
		int port = 10000;
		
		try {
			ss = new ServerSocket(port);
			System.out.println("服务器已启动");
			while (true) {
				socket = ss.accept();
				
				//启动线程
				new LogicThread(socket);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
