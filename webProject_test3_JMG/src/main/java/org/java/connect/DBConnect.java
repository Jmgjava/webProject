package org.java.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	public static Connection DBConnection() {
		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "system";
		String userPw = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
			System.out.println("드라이버 O");

			conn = DriverManager.getConnection(url, userId, userPw);
			System.out.println("DB연결 O");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 X");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 X");
			e.printStackTrace();
		}

		return conn;
	}

}
