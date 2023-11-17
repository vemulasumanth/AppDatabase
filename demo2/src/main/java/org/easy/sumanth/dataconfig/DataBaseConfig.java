package org.easy.sumanth.dataconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConfig {
	public static Connection getConnection()
	{
		String url="jdbc:mysql://localhost:3306/sumanth?useSSL=false";
		String Username="root";
		String Password="Sumanth@123";
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		conn=DriverManager.getConnection(url,Username,Password);
		}
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
