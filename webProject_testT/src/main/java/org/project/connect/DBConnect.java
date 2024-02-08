package org.project.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() {

		Connection conn = null;

		// 오라클
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String password = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";
		// mysql
//		String url = "jdbc:mysql://localhost:3306/testdb";
//		String user = "root";
//		String password = "1234";
//		String driver = "com.mysql.cj.jdbc.Driver";
		
		// mySql
		try {
			Class.forName(driver);
			System.out.println("드라이버OK!");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연동 Success!");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버NO!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연동 Fail!");
			e.printStackTrace();
		}

		return conn;
	}
}