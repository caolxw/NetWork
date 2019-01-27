package example.tcp;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * TCP 服务器端
 * 使用线程池处理并发情况
 */
public class MulThreadSocketServer2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int port = 10000;
		ServerSocket ss = new ServerSocket(port);
		
		//创建线程池
		ExecutorService threadPool = Executors.newFixedThreadPool(100);
		
		while(true) {
			Socket socket = ss.accept();
			
			Runnable runnable = ()->{
				try {
					InputStream is = socket.getInputStream();
					byte[] b = new byte[1024];
					int len;
					StringBuilder sb = new StringBuilder();
					
					while((len = is.read(b)) != -1) {
						sb.append(new String(b, 0, len));
					}
					
					System.out.println("客户端的数据：" + sb);
					
					is.close();
					socket.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			};
			
			threadPool.submit(runnable);
			
		}
	}

}
