package dad.javafx.owncomputer.model;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Ticket {

	private ListProperty<Component> components = new SimpleListProperty<Component>(FXCollections.observableArrayList());

	public final ListProperty<Component> componentsProperty() {
		return this.components;
	}

	public final ObservableList<Component> getComponents() {
		return this.componentsProperty().get();
	}

	public final void setEmails(final ObservableList<Component> components) {
		this.componentsProperty().set(components);
	}
}
