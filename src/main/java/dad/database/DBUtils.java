package dad.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dad.javafx.owncomputer.model.Component;

public class DBUtils {
	
	/* Clase para implementar los metodos de
	 * la base de datos a la hora de llenar
	 * las listas de componentes
	 */
	
	public static void fillCPUTable(List<Component> list, String socket_selected) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameCPU, priceCPU "
					+ "FROM CPU "
					+ "INNER JOIN socket on CPU.socket = socket.idSocket "
					+ "WHERE socket.nameSo='" + socket_selected + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Component(rs.getString("nameCPU"), rs.getDouble("priceCPU")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillMotherboardTable(List<Component> list, String socket_selected, String disk_selected, String RAM_selected) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameMother, priceMother "
					+ "FROM motherboard "
					+ "INNER JOIN socket on motherboard.socket = socket.idSocket "
					+ "INNER JOIN diskConnector on motherboard.diskConnector = diskConnector.idConnector "
					+ "INNER JOIN ramType on motherboard.ramType = ramType.idType "
					+ "WHERE (socket.nameSo='" + socket_selected + "') AND (diskConnector.nameConnector='" + disk_selected + "') AND (ramType.nameType='" + RAM_selected + "')";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Component(rs.getString("nameMother"), rs.getDouble("priceMother")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillHeatSinksTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nameHeat, priceHeat FROM heatSinks";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Component(rs.getString("nameHeat"), rs.getDouble("priceHeat")));
			}
		} catch(SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillRAMTable(List<Component> list, String RAM_selected) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nameRam, priceRam "
					+ "FROM ram "
					+ "INNER JOIN ramType on ramType.idType = ram.type "
					+ "WHERE ramType.nameType='" + RAM_selected + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Component(rs.getString("nameRam"), rs.getDouble("priceRam")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillGraphicsTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nameGraphic, priceGraphic FROM graphicCard";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameGraphic"), rs.getDouble("priceGraphic")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillHardDiskTable(List<Component> list, String disk_selected) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nameDisk, priceDisk "
					+ "FROM hardDisk "
					+ "INNER JOIN diskConnector on hardDisk.diskConnector = diskConnector.idConnector "
					+ "WHERE diskConnector.nameConnector='" + disk_selected + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Component(rs.getString("nameDisk"), rs.getDouble("priceDisk")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillPowerSupplyTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT namePower, pricePower FROM powerSupply";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("namePower"), rs.getDouble("pricePower")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}
	
	public static void fillCaseTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameCase, priceCase FROM caseDesktop";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameCase"), rs.getDouble("priceCase")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	public static void fillOthersTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT DISTINCT nameScreen, priceScreen FROM screens";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameScreen"), rs.getDouble("priceScreen")));
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		
	}

	public static void showInfo(String name, int table) {
		// TODO Auto-generated method stub
		
		
		switch (table) {
		
		case 1:
			
		case 2:
		
		case 3:
			
		case 4:
			
		case 5:
			
		case 6:
			
		case 7:
			
		case 8:
			
		case 9:
		}
	}
	
	public void showInfoWindow(String info) {
		
		
	}
}
