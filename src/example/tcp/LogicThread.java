package example.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 服务器端逻辑线程
 */
public class LogicThread extends Thread {
	Socket socket;
	InputStream is;
	OutputStream os;
	
	public LogicThread(Socket socket) {
		this.socket = socket;
		//启动线程
		start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		byte[] b = new byte[1024];
		
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
			for (int i = 0; i < 3; i++) {
				int len = is.read(b);
				//逻辑处理
				byte[] response = logic(b,0,len);
				
				os.write(response);
			}
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


	private byte[] logic(byte[] b, int i, int len) {
		// TODO Auto-generated method stub
		byte[] response = new byte[1024];
		//将数据拷贝到数组当中
		System.arraycopy(b, 0, response, 0, len);
		return response;
	}
}
