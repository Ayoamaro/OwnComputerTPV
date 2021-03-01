package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is used to get the socket, disk and ram types that will be used to filter the data
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */

public class Compatibility {

private StringProperty socket;
private StringProperty typeDisk;
private StringProperty typeRAM;
	
	public Compatibility(String socket, String typeDisk, String typeRAM) {
		this.socket = new SimpleStringProperty(socket);
		this.typeDisk = new SimpleStringProperty(typeDisk);
		this.typeRAM = new SimpleStringProperty(typeRAM);
	}

	public Compatibility() {
		// TODO Auto-generated constructor stub
	}

	public StringProperty socketProperty() {
		return this.socket;
	}
	
	public String getSocket() {
		return this.socketProperty().get();
	}
	
	public void setSocket(String socket) {
		this.socketProperty().set(socket);
	}
	
	public StringProperty typeDiskProperty() {
		return this.typeDisk;
	}
	
	public String getTypeDisk() {
		return this.typeDiskProperty().get();
	}
	
	public void setTypeDisk(String typeDisk) {
		this.typeDiskProperty().set(typeDisk);
	}
	
	public StringProperty typeRAMProperty() {
		return this.typeRAM;
	}
	
	public String getTypeRAM() {
		return this.typeRAMProperty().get();
	}
	
	public void setTypeRAM(String typeRAM) {
		this.typeRAMProperty().set(typeRAM);
	}

	@Override
	public String toString() {
		return socket.getValue() + typeDisk.getValue() + typeRAM.getValue();
	}
}
