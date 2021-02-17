package dad.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.jdi.connect.spi.Connection;

public class MainDataBase {
	public static void main(String[] args) {
		DbConnection.connect();
	}
	
	private static void readCPUtable() throws IOException {
		Connection con = (Connection) DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "Select nameCPU, core, frecuency, socket, price from CPU";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String nameCPU = rs.getString("nameCPU");
				String core = rs.getString("core");
				String frecuency = rs.getString("frecuency");
				String socket = rs.getString("socket");
				String price = rs.getString("price");
				
				System.out.println(nameCPU);
				System.out.println(core);
				System.out.println(frecuency);
				System.out.println(socket);
				System.out.println(price+"\n");
			}
		}catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
			rs.close();
			ps.close();
			con.close();
			}catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}

}
