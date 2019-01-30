package example.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * java发送http的get post 请求
 */
public class HTTPRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.so.com/s?ie=utf-8&src=hao_360so_b&shb=1&hsid=58a8dee1cc87f001&q=java+http
		Map<String, String> map = new HashMap<String, String>();
		map.put("ie", "utf-8");
		map.put("src", "hao_360so_b");
		map.put("shb", "1");
		map.put("hsid", "58a8dee1cc87f001");
		map.put("q", "java+http");
		String string = sendGet("http://www.so.com", map);		//返回200 OK
		System.out.println(string);
		
		System.out.println();
		
		String string２ = sendPOST("https://baidu.com", map);
		System.out.println(string２);
	}

	/*
	 * 向指定的URL发送GET方法请求
	 * 
	 * url 发送请求的URL
	 * param 请求参数
	 */
	public static String sendGet(String url, Map param) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		
		try {
			//拼接URL
			String urlString = url + "?" + getMapString(param);
			URL realurl = new URL(urlString);
			
			URLConnection conn = realurl.openConnection();
			
			//设置通用请求
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			//建立实际连接
			conn.connect();
			
			//获取响应头字节
			Map<String, List<String>> map = conn.getHeaderFields();
			
			for (String key : map.keySet()) {
				System.out.println(key + " --- " + map.get(key));
			}
			
			//读取URL响应
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("GET 请求异常：" + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return sb.toString();
	}

	/*
	 * 向指定的URL发送POST请求
	 * 
	 * 
	 */
	public static String sendPOST(String url, Map param) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			URL realurl = new URL(url);
			URLConnection conn = realurl.openConnection();
			
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			//发送POST必须要设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			pw = new PrintWriter(conn.getOutputStream());
			pw.print(getMapString(param));
			pw.flush();
			
			//读取URL响应
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("POST 请求异常：" + e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return sb.toString();
	}
	private static String getMapString(Map param) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		Set set = param.keySet();
		Iterator iterator = set.iterator();
		
		int n = 1;
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = param.get(key).toString();
			sb.append(key + "=" + value);
			if (n != param.size()) {
				sb.append("&");
			}
			n ++;
		}
		return sb.toString();
	}
}
