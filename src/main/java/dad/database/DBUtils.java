package dad.database;

import java.io.IOException;
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
		Component component;
		try {
			String sql = "Select nameCPU, price from CPU";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
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
	
	public static void fillMotherboardTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select name, price from motherboard";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("name"));
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
	
	public static void fillHeatSinksTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameHeat, priceHeat from heatSinks";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameHeat"));
				component.setPrice(Double.parseDouble(rs.getString("priceHeat")));
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
	
	public static void fillRAMTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameRam, price from ram";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameRam"));
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
	
	public static void fillGraphicsTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameGraphic, price from graphicCard";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameGraphic"));
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
	
	public static void fillHardDiskTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameDisk, price from disk";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameDisk"));
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
	
	public static void fillPowerSupplyTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select namePower, price from powerSupply";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("namePower"));
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
	
	public static void fillCaseTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameCase, priceCase from case";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameCase"));
				component.setPrice(Double.parseDouble(rs.getString("priceCase")));
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
	
	public static void fillOthersTable(List<Component> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Component component;
		try {
			String sql = "Select nameScreen, price from screens";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				component = new Component();
				component.setName(rs.getString("nameScreen"));
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
