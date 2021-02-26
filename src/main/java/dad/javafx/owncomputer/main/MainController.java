package dad.javafx.owncomputer.main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.database.DBUtils;
import dad.javafx.owncomputer.model.Compatibility;
import dad.javafx.owncomputer.model.Component;
import dad.javafx.owncomputer.model.Disk;
import dad.javafx.owncomputer.model.RAM;
import dad.javafx.owncomputer.model.Socket;
import dad.javafx.owncomputer.util.DialogInfo;
import javafx.application.Platform;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	private ListProperty<Component> component_List = new SimpleListProperty<Component>(FXCollections.observableArrayList());
	private ListProperty<Socket> socket_list = new SimpleListProperty<Socket>(FXCollections.observableArrayList());
	private ListProperty<Disk> disk_list = new SimpleListProperty<Disk>(FXCollections.observableArrayList());
	private ListProperty<RAM> RAM_list = new SimpleListProperty<RAM>(FXCollections.observableArrayList());
	private List<Component> list_component = new ArrayList<Component>();
	private String socket_selected, disk_selected, RAM_selected;
	private int comp;
	private double total = 0d;
	
	// VIEW
	@FXML
	private BorderPane view;
	
    @FXML
    private MenuItem NewButton;

    @FXML
    private MenuItem OpenButton;

    @FXML
    private MenuItem SaveButton;

    @FXML
    private MenuItem SaveAllButton;

    @FXML
    private MenuItem ExitButton;
    
	@FXML
	private Button settingsBTN, cpuBTN, motherboardBTN, heatsinkBTN, memoryramBTN, graphiccardBTN, harddiskBTN, powersupplyBTN,
			caseBTN, devicesBTN, addBTN, removeBTN, infoBTN, finishBTN;
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

		try {
			DialogInfo.disableButtons(cpuBTN, motherboardBTN, heatsinkBTN, memoryramBTN, graphiccardBTN, harddiskBTN, powersupplyBTN, caseBTN, devicesBTN);
			DialogInfo.getSocket(socket_list);
			DialogInfo.getDisk(disk_list);
			DialogInfo.getRAM(RAM_list);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	
    @FXML
    void onExitAction(ActionEvent event) { 
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("Are you sure?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			System.exit(0);
		}
    }
    @FXML
    void onNewAction(ActionEvent event) { 
		
    }
    @FXML
    void onOpenAction(ActionEvent event) { }
    @FXML
    void onSaveAction(ActionEvent event) { }
    @FXML
    void onSaveAllAction(ActionEvent event) { }

	@FXML
	void onSettingsAction(ActionEvent event) throws IOException {
		Dialog<Compatibility> tab = new Dialog<Compatibility>();
		tab.setTitle("Choose settings");
		
		ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
		tab.getDialogPane().getButtonTypes().addAll(okButton, ButtonType.CANCEL);

		Stage stage = (Stage) tab.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(this.getClass().getResource("/images/owncomputer-icon.png").toString()));
		
		// CREATE SCENE TAB WITH GRIDPANE
		GridPane scene = new GridPane();
		scene.setHgap(10);
		scene.setVgap(10);
		scene.setPadding(new Insets(15, 150, 15, 15));

		ComboBox socketAvailable = new ComboBox();
		socketAvailable.getItems().addAll(socket_list.getValue());
		ComboBox typeDiskAvailable = new ComboBox();
		typeDiskAvailable.getItems().addAll(disk_list.getValue());
		ComboBox typeRamAvailable = new ComboBox();
		typeRamAvailable.getItems().addAll(RAM_list.getValue());
		
		scene.addRow(0, new Label("Select your initial configuration"));
		scene.addRow(1, new Label("Available Sockets: "), socketAvailable);
		scene.addRow(2, new Label("Available Hard-Disk: "), typeDiskAvailable);
		scene.addRow(3, new Label("Available Type RAM: "), typeRamAvailable);

		tab.getDialogPane().setContent(scene);
		
		tab.setResultConverter(tabButton -> {
			if (tabButton == okButton) {
				String socket = socketAvailable.getSelectionModel().getSelectedItem().toString();
				String typeDisk = typeDiskAvailable.getSelectionModel().getSelectedItem().toString();
				String typeRAM = typeRamAvailable.getSelectionModel().getSelectedItem().toString();
	
				Compatibility newCompatibility = new Compatibility(socket, typeDisk, typeRAM);
				
	    		return newCompatibility;
			}
			return null;
		});
		
		Optional<Compatibility> result = tab.showAndWait();
		if (result.isPresent()) {
			DialogInfo.activateButtons(cpuBTN, motherboardBTN, heatsinkBTN, memoryramBTN, graphiccardBTN, harddiskBTN, powersupplyBTN, caseBTN, devicesBTN);
			settingsBTN.setText("Socket selected: " + result.get().getSocket());
			socket_selected = result.get().getSocket();
			disk_selected = result.get().getTypeDisk();
			RAM_selected = result.get().getTypeRAM();
		}
	}
	
	@FXML
	void onCPU_Pressed(ActionEvent event) throws IOException {
		comp = 1;
		component_List.clear();
		list_component.clear();
		DBUtils.fillCPUTable(list_component, socket_selected);
		component_List.addAll(list_component);
	}

	@FXML
	void onMotherboard_Pressed(ActionEvent event) throws IOException {
		comp = 2;
		component_List.clear();
		list_component.clear();
		DBUtils.fillMotherboardTable(list_component, socket_selected, disk_selected, RAM_selected);
		component_List.addAll(list_component);
	}

	@FXML
	void onHeatSkin_Pressed(ActionEvent event) throws IOException {
		comp = 3;
		component_List.clear();
		list_component.clear();
		DBUtils.fillHeatSinksTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onRAM_Pressed(ActionEvent event) throws IOException {
		comp = 4;
		component_List.clear();
		list_component.clear();
		DBUtils.fillRAMTable(list_component, RAM_selected);
		component_List.addAll(list_component);
	}

	@FXML
	void onGraphicCard_Pressed(ActionEvent event) throws IOException {
		comp = 5;
		component_List.clear();
		list_component.clear();
		DBUtils.fillGraphicsTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onMemory_Pressed(ActionEvent event) throws IOException {
		comp = 6;
		component_List.clear();
		list_component.clear();
		DBUtils.fillHardDiskTable(list_component, disk_selected);
		component_List.addAll(list_component);
	}

	@FXML
	void onPowerSupply_Pressed(ActionEvent event) throws IOException {
		comp = 7;
		component_List.clear();
		list_component.clear();
		DBUtils.fillPowerSupplyTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onCase_Pressed(ActionEvent event) throws IOException {
		comp = 8;
		component_List.clear();
		list_component.clear();
		DBUtils.fillCaseTable(list_component);
		component_List.addAll(list_component);
	}

	@FXML
	void onDevices_Pressed(ActionEvent event) throws IOException {
		comp = 9;
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
		total = total + selected.getPrice();
		finalpriceTXT.setText(String.format("%.2f", total));
	}
	
	@FXML
	void onRemoveProduct(ActionEvent event) { 
		Component lastComponent = tableviewTicket.getSelectionModel().getSelectedItem();
		
		tableviewTicket.getItems().remove(lastComponent);
		total = total - lastComponent.getPrice();
		finalpriceTXT.setText(String.format("%.2f", total));
	}
	
	@FXML
    void onInfoProduct(ActionEvent event) {
		String nameComponent = tableviewComponents.getSelectionModel().getSelectedItem().getName();
		DBUtils.showInfo(nameComponent, comp);
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
