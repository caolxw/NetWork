package example.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket = null;
		OutputStream os = null;
		
		String IP = "127.0.0.1";
		int port = 10000;
		
		try {
			socket = new Socket(IP, port);
			os = socket.getOutputStream();
			
			Scanner scanner = new Scanner(System.in);
			String data = null;
			while (!(data = scanner.nextLine()).equals("equit")) {
				os.write(data.getBytes());
			}
			socket.shutdownOutput();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				os.close();   
				socket.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
