package dad.database;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dad.javafx.owncomputer.main.MainController;
import dad.javafx.owncomputer.model.Component;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
	
	public static void fillScreensTable(List<Component> list) throws IOException {
		
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

	public static void showInfo(String name, int table) throws IOException {
		// TODO Auto-generated method stub
		
		
		switch (table) {
		
		case 1:
			showInfoWindow(infoCPU(name));
			break;
		case 2:
			showInfoWindow(infoMotherboard(name));
			break;
		case 3:
			showInfoWindow(infoHeatSink(name));
			break;
		case 4:
			showInfoWindow(infoRam(name));
			break;
		case 5:
			showInfoWindow(infoGraphics(name));
			break;
		case 6:
			showInfoWindow(infoHardDisk(name));
			break;
		case 7:
			showInfoWindow(infoPowerSupply(name));
			break;
		case 8:
			showInfoWindow(infoScreen(name));
			break;
		}
	}
	
	public static void showInfoWindow(String info) throws IOException {
	
        HBox root = new HBox();
        Label infoComponent =  new Label();
        infoComponent.setText(info);
        root.setAlignment(Pos.CENTER);
        
        
        root.getChildren().addAll(infoComponent);
        Scene scene = new Scene(root, 500, 350);
        infoComponent.getStyleClass().add("info");
		scene.getStylesheets().add(MainController.class.getResource("/css/darkTheme.css").toExternalForm());
        Stage stage = new Stage();
        stage.setTitle("Info Component");
        stage.setScene(scene);
        stage.show();
	}
	
	private static String infoCPU(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT core, frecuency, nameSo, priceCPU FROM CPU "
					+ "inner join socket on CPU.socket = socket.idsocket "
					+ "where nameCPU = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of CPU: " + name + "\n"
					+ "Number of cores: " + rs.getInt("core") + "\n"
					+ "Frecuency: " + rs.getString("frecuency") + "\n"
					+ "Type of Socket: " + rs.getString("nameSo") + "\n"
					+ "Price: " + rs.getInt("priceCPU");
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
		
		return info;
	}
	
	private static String infoMotherboard(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameType, nameSo, nameConnector, priceMother FROM motherboard "
					+ "inner join ramType on motherboard.ramType=ramType.idType "
					+ "inner join socket on motherboard.socket = socket.idSocket "
					+ "inner join diskConnector on motherboard.diskConnector=diskConnector "
					+ "where nameMother = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Motherboard: " + name + "\n"
					+ "Type of RAM: " + rs.getString("nameType") + "\n"
					+ "Disk connector: " + rs.getString("nameConnector") + "\n"
					+ "Type of Socket: " + rs.getString("nameSo") + "\n"
					+ "Price: " + rs.getInt("priceMother");
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
		
		return info;
	}
	
	private static String infoRam(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT nameType, capacity, priceRam FROM ram "
					+ "inner join ramType on ram.type=ramType.idType "
					+ "where nameRam = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Ram: " + name + "\n"
					+ "Type of connector: " + rs.getString("nameType") + "\n"
					+ "Capacity: " + rs.getString("capacity") + "\n"
					+ "Price: " + rs.getInt("priceRam");
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
		
		return info;
	}
	
	private static String infoGraphics(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT memory, priceGraphic FROM graphicCard "
					+ "where nameGraphic = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Graphic Card: " + name + "\n"
					+ "Memory: " + rs.getString("memory") + "\n"
					+ "Price: " + rs.getInt("priceGraphic");
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
		
		return info;
	}
	
	private static String infoHardDisk(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM hardDisk "
					+ "inner join diskConnector on hardDisk.diskConnector=diskConnector.idConnector "
					+ "where nameDisk = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Hard Disk: " + name + "\n"
					+ "Connector: " + rs.getString("nameConnector") + "\n"
					+ "Type of Disk: " + rs.getString("type") + "\n"
					+ "Capacity: " + rs.getString("capacity") + "\n"
					+ "Price: " + rs.getInt("priceDisk");
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
		
		return info;
	}
	
	private static String infoHeatSink(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT voltage, power, priceHeat FROM heatSinks "
					+ "where nameHeat = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Heat Sink: " + name + "\n"
					+ "Voltage: " + rs.getString("voltage") + "\n"
					+ "Power: " + rs.getString("power") + "\n"
					+ "Price: " + rs.getInt("priceHeat");
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
		
		return info;
	}
	
	private static String infoPowerSupply(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT power, pricePower FROM powerSupply "
					+ "where namePower = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Power Supply: " + name + "\n"
					+ "Power: " + rs.getString("power") + "\n"
					+ "Price: " + rs.getInt("pricePower");
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
		
		return info;
	}
	
	private static String infoScreen(String name) {
		String info = "";
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT resolution, inch, priceScreen FROM screens "
					+ "where nameScreen = '" + name + "'";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			info = "Name of Screen: " + name + "\n"
					+ "Resolution: " + rs.getString("resolution") + "\n"
					+ "Inch: " + rs.getInt("inch") + "\n"
					+ "Price: " + rs.getInt("priceScreen");
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
		
		return info;
	}
}
