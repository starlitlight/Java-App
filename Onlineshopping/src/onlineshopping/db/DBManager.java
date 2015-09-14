package onlineshopping.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(Config.DRIVER);
			conn = DriverManager.getConnection(Config.URL, Config.username,
					Config.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
