package dad.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sun.jdi.connect.spi.Connection;

import dad.javafx.owncomputer.util.Component;

public class DBUtils {
	
	/* Clase para implementar los metodos de
	 * la base de datos a la hora de llenar
	 * las listas de componentes
	 */
	
	public static void fillCPUTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DbConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "Select nameCPU, price from CPU";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Component component = new Component();
				component.setName(rs.getString("nameCPU"));
				component.setPrice(Double.parseDouble(rs.getString("price")));
				list.add(component);
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
