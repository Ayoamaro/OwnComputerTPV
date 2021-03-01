package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 * This class is used to get the Scoket data
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */
public class Socket {

	private StringProperty socket;
	
	public Socket(String socket) {
		this.socket = new SimpleStringProperty(socket);
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
	
	@Override
	public String toString() {
		return socket.getValue();
	}
}
