package dad.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:src\\main\\resources\\database\\ComponentsBD.db");
			System.out.println("Connected!");
		} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
		return con;
	}
}
