package example.inetaddress;

import java.net.InetAddress;

/*
 * InetAddress类的基本使用
 */
public class InetAddressDemo {
	public static void main(String[] args) {
		try {
			//使用域名创建对象
			InetAddress inet1 = InetAddress.getByName("www.baidu.com");
			System.out.println(inet1);
			
			//使用IP地址创建对象
			InetAddress inet2 = InetAddress.getByName("127.0.0.1");
			System.out.println(inet2);
			
			//获得本机地址对象
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println(inet3);
			
			//获得对象中的域名
			String host = inet3.getHostName();
			System.out.println(host);
			
			//获得对象的IP地址
			String ip = inet3.getHostAddress();
			System.out.println(ip);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

/*
 * 执行结果：
www.baidu.com/115.239.211.112
/127.0.0.1
DESKTOP-V6NAI3L/192.168.11.102
DESKTOP-V6NAI3L
192.168.11.102
*/
