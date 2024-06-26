package dbHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private static Connection conn;

	public static Connection getConnection(String url, String userName, String password) {

		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(url, userName, password);
				System.out.println("connection-------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
