package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is used to get the Ram data
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */

public class Disk {

	private StringProperty typeDisk;
	
	public Disk(String typeDisk) {
		this.typeDisk = new SimpleStringProperty(typeDisk);
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
	
	@Override
	public String toString() {
		return typeDisk.getValue();
	}
}
