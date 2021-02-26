package dad.javafx.owncomputer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RAM {

	private StringProperty typeRAM;
	
	public RAM(String typeRAM) {
		this.typeRAM = new SimpleStringProperty(typeRAM);
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
		return typeRAM.getValue();
	}
}
