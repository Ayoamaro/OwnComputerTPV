package dad.javafx.owncomputer.util;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dad.database.DBConnection;
import dad.javafx.owncomputer.model.Disk;
import dad.javafx.owncomputer.model.RAM;
import dad.javafx.owncomputer.model.Socket;
import javafx.scene.control.Button;

/**
 * This class is used to filter the data in the tableView 
 * according to the specifications given by the user
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */

public class DialogInfo {
	
	/*Constructor to obtain the data from socket list*/

	public static void getSocket(List<Socket> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameSo FROM socket";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Socket(rs.getString("nameSo")));
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
	
	/*Constructor to obtain the data from disk list*/
	
	public static void getDisk(List<Disk> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameConnector FROM diskConnector";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Disk(rs.getString("nameConnector")));
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
	
	/*Constructor to obtain the data from ram list*/
	
	public static void getRAM(List<RAM> list) throws IOException {
		
		java.sql.Connection con =  DBConnection.connect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT DISTINCT nameType FROM ramType";
			ps = ((java.sql.Connection) con).prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new RAM(rs.getString("nameType")));
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
	
	/*Constructors disable and enable the buttons*/
	
	public static void activateButtons(Button cpuBTN, Button motherboardBTN, Button heatsinkBTN, Button memoryramBTN, Button graphiccardBTN, Button harddiskBTN, Button powersupplyBTN, Button caseBTN, Button devicesBTN) {
		cpuBTN.setDisable(false);
		motherboardBTN.setDisable(false);
		heatsinkBTN.setDisable(false);
		memoryramBTN.setDisable(false);
		graphiccardBTN.setDisable(false);
		harddiskBTN.setDisable(false);
		powersupplyBTN.setDisable(false);
		caseBTN.setDisable(false);
		devicesBTN.setDisable(false);
	}
	
	public static void disableButtons(Button cpuBTN, Button motherboardBTN, Button heatsinkBTN, Button memoryramBTN, Button graphiccardBTN, Button harddiskBTN, Button powersupplyBTN, Button caseBTN, Button devicesBTN) {
		cpuBTN.setDisable(true);
		motherboardBTN.setDisable(true);
		heatsinkBTN.setDisable(true);
		memoryramBTN.setDisable(true);
		graphiccardBTN.setDisable(true);
		harddiskBTN.setDisable(true);
		powersupplyBTN.setDisable(true);
		caseBTN.setDisable(true);
		devicesBTN.setDisable(true);
	}
}
