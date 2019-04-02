package com.yitengtech.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yitengtech.bean.Position;

public class SQLUtil {
	public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/mydb" + 
	"?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
	
	private static String user = "root";
	private static String pwd = "root";
	
	public static List<Position> selectBymac(String mac) throws Exception {
		Connection conn = null;
		Statement stat = null;
		
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, user, pwd);
		System.out.println("数据库连接成功");
		
		stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("select lon, lat from points where mac = '" + mac + "'");
		List list = new ArrayList();
		
		while (rs.next()) {
			Position p = new Position(rs.getDouble(1), rs.getDouble(2));
			list.add(p);
		}
		
		conn.close();
		stat.close();
		rs.close();
		
		return list;
	}
}
