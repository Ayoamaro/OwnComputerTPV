package dad.javafx.owncomputer.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Component {
	
	private StringProperty name;
	private DoubleProperty price;
	private String routeImage = "images/owncomputer-icon.png";
	
	public Component(String name, Double price) {
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
	}
	
	public Component() {
		// TODO Auto-generated constructor stub
	}

	public StringProperty nameProperty() {
		return this.name;
	}
	
	public String getName() {
		return this.nameProperty().get();
	}
	
	public void setName(String name) {
		this.nameProperty().set(name);
	}
	
	public DoubleProperty priceProperty() {
		return this.price;
	}
	
	public double getPrice() {
		return this.priceProperty().get();
	}
	
	public void setPrice(double price) {
		this.priceProperty().set(price);
	}

	public String getRouteImage() {
		return routeImage;
	}

	public void setRouteImage(String routeImage) {
		this.routeImage = routeImage;
	}
}
