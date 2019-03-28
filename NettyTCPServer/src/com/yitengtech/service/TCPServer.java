package com.yitengtech.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.yitengtech.bean.Position;


public class TCPServer {
	public static int port = 88; // 指定接收端口
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExecutorService threadpool = Executors.newFixedThreadPool(100);
		ServerSocket ss = new ServerSocket(port);
		while(true){
		    Socket socket = ss.accept();
		    
		    Runnable runnable = ()->{
		        try{
		            InputStream is = socket.getInputStream();
		            byte[] b = new byte[1024];
		            int len;
		            StringBuffer sb = new StringBuffer();
		            
		            while((len = is.read(b)) != -1){
		                sb.append(new String(b, 0, len));
		            }
		            
		            System.out.println(sb);
		            OutputStream os = socket.getOutputStream();
		    		os.write(new Position().toString().getBytes());
		    		
		    		is.close();
		    		os.close();
		    		socket.close();
		        }catch(Exception e){}
		    };
		    
		    threadpool.submit(runnable);
		}
	}

}
