package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
