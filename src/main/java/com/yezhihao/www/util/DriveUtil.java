package com.yezhihao.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DriveUtil {
	private static String dbUrl="jdbc:mysql://localhost:3306/book_system";
	private static String dbUserName="root";
	private static String dbPassword="123456";
	private static String jdbcName="com.mysql.jdbc.Driver";
	public static	Connection getcon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	public static void close(Connection con,PreparedStatement sta)throws Exception{
		if(sta!=null){
			sta.close();
		}
		if(con!=null){
			con.close();
		}
	}
}
