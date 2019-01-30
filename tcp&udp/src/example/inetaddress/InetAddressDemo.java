package example.inetaddress;

import java.net.InetAddress;

/*
 * InetAddress��Ļ���ʹ��
 */
public class InetAddressDemo {
	public static void main(String[] args) {
		try {
			//ʹ��������������
			InetAddress inet1 = InetAddress.getByName("www.baidu.com");
			System.out.println(inet1);
			
			//ʹ��IP��ַ��������
			InetAddress inet2 = InetAddress.getByName("127.0.0.1");
			System.out.println(inet2);
			
			//��ñ�����ַ����
			InetAddress inet3 = InetAddress.getLocalHost();
			System.out.println(inet3);
			
			//��ö����е�����
			String host = inet3.getHostName();
			System.out.println(host);
			
			//��ö����IP��ַ
			String ip = inet3.getHostAddress();
			System.out.println(ip);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

/*
 * ִ�н����
www.baidu.com/115.239.211.112
/127.0.0.1
DESKTOP-V6NAI3L/192.168.11.102
DESKTOP-V6NAI3L
192.168.11.102
*/
