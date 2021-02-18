package dad.javafx.owncomputer.main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dad.database.DBUtils;
import dad.javafx.owncomputer.util.Component;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {
	
	private ListProperty<Component> component_List = new SimpleListProperty<Component>(FXCollections.observableArrayList());
	private List<Component> list_component = new ArrayList<Component>();
	
	// VIEW
	@FXML
	private BorderPane view;
	@FXML
	private Button cpuBTN, motherboardBTN, heatsinkBTN, memoryramBTN, graphiccardBTN, harddiskBTN, powersupplyBTN,
			caseBTN, devicesBTN, addBTN, removeBTN, finishBTN;
	@FXML
	private TableView<Component> tableviewComponents, tableviewTicket;
	@FXML
	private TableColumn<Component, String> nameColumn_Comp, nameColumn_Ticket;
	@FXML
	private TableColumn<Component, Number> priceColumn_Comp, priceColumn_Ticket;
	@FXML
	private TextField finalpriceTXT;

	// CONSTRUCTOR
	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		loader.setController(this);
		loader.load();
	}

	// INITIALIZE
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		tableviewComponents.itemsProperty().bind(component_List);
		
		nameColumn_Ticket.setCellValueFactory(new PropertyValueFactory<Component, String>("name"));
		priceColumn_Ticket.setCellValueFactory(new PropertyValueFactory<Component, Number>("price"));
		nameColumn_Comp.setCellValueFactory(new PropertyValueFactory<Component, String>("name"));
		priceColumn_Comp.setCellValueFactory(new PropertyValueFactory<Component, Number>("price"));
	 }

	@FXML
	void onCPU_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillCPUTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onMotherboard_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillMotherboardTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onHeatSkin_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillHeatSinksTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onRAM_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillRAMTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onGraphicCard_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillGraphicsTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onMemory_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillHardDiskTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onPowerSupply_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillPowerSupplyTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onCase_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillCaseTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onDevices_Pressed(ActionEvent event) throws IOException {
		component_List.clear();
		list_component.clear();
		DBUtils.fillOthersTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onAddProduct(ActionEvent event) { 
		Component selected = tableviewComponents.getSelectionModel().getSelectedItem();
		Component addComponent = new Component(selected.getName().toString(), selected.getPrice());
		
		tableviewTicket.getItems().add(addComponent);
	}
	
	@FXML
	void onRemoveProduct(ActionEvent event) { 
		Component lastComponent = tableviewTicket.getSelectionModel().getSelectedItem();
		
		tableviewTicket.getItems().remove(lastComponent);
	}

	@FXML
	void onFinishAction(ActionEvent event) { }

	@FXML
	void onPayAction(ActionEvent event) { }

	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}
}
