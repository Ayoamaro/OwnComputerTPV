package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
