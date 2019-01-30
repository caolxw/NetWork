package example.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ss = null;
		Socket socket = null;
		InputStream is = null;
		
		int port = 10000;
		
		try {
			ss = new ServerSocket(port);
			socket = ss.accept();
			is = socket.getInputStream();
			
			File file = new File("info.txt");
			FileOutputStream fos = new FileOutputStream(file,true);
			PrintStream ps = new PrintStream(fos);
			byte[] b = new byte[1024];
			int len;
			
			while ((len = is.read(b)) != -1) {
				String string = new String(b, 0, len);
				System.out.println("接收到客户端数据：" + string);
				
				ps.println(string);
				
			}
			fos.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				is.close();
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
