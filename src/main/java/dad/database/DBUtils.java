package dad.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dad.javafx.owncomputer.util.Component;

public class DBUtils {
	
	/* Clase para implementar los metodos de
	 * la base de datos a la hora de llenar
	 * las listas de componentes
	 */
	
	public static void fillCPUTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "Select nameCPU, priceCPU from CPU";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameCPU"), rs.getDouble("priceCPU")));
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
	
	public static void fillMotherboardTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT nameMother, priceMother FROM motherboard inner join socket on socket.idSocket = motherboard.socket "
					+ "inner join CPU on socket.idSocket = CPU.socket";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameMother"), rs.getDouble("priceMother")));
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
	
	public static void fillHeatSinksTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameHeat, priceHeat FROM heatSinks";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameHeat"), rs.getDouble("priceHeat")));
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
	
	public static void fillRAMTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameRam, priceRam FROM ram inner join ramType on ramType.idType = ram.type "
					+ "inner join motherboard on motherboard.ramType = ramType.idType";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameRam"), rs.getDouble("priceRam")));
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
	
	public static void fillGraphicsTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameGraphic, priceGraphic FROM graphicCard";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameGraphic"), rs.getDouble("priceGraphic")));
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
	
	public static void fillHardDiskTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			/*No funciona 22/02/2020*/
			String sql = "SELECT nameDisk, priceDisk FROM disk inner join diskConnector on diskConnector.idConnector = disk.diskConnector"
					+ "inner join motherboard on motherboard.diskConnector = diskConnector.idConnector";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameDisk"), rs.getDouble("priceDisk")));
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
	
	public static void fillPowerSupplyTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT namePower, pricePower FROM powerSupply";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("namePower"), rs.getDouble("pricePower")));
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
	
	public static void fillCaseTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT nameCase, priceCase FROM caseDesktop";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameCase"), rs.getDouble("priceCase")));
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
	
	public static void fillOthersTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameScreen, priceScreen FROM screens";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Component(rs.getString("nameScreen"), rs.getDouble("priceScreen")));
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
