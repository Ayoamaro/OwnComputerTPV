package dad.javafx.owncomputer.main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.owncomputer.util.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MainController implements Initializable {

	private ObservableList<Component> component_list;
	
	// VIEW
	@FXML
	private BorderPane view;
	@FXML
	private Button cpuBTN, motherboardBTN, heatsinkBTN, memoryramBTN, graphiccardBTN, harddiskBTN, powersupplyBTN,
			caseBTN, devicesBTN, addBTN, quantityBTN, deleteBTN, priceBTN, discountBTN, taxesBTN, purchaseBTN;
	@FXML
	private TableView<Component> tableviewComponents, tableviewTicket;
	@FXML
	private TableColumn<Component, String> nameColumn_Comp, nameColumn_Ticket;
	@FXML
	private TableColumn<Component, Double> priceColumn_Comp, priceColumn_Ticket;
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
	public void initialize(URL location, ResourceBundle resources) { }

	
	@FXML
	void onCPU_Pressed(ActionEvent event) { }

	@FXML
	void onMotherboard_Pressed(ActionEvent event) { }

	@FXML
	void onHeatSkin_Pressed(ActionEvent event) { }

	@FXML
	void onRAM_Pressed(ActionEvent event) { }

	@FXML
	void onGraphicCard_Pressed(ActionEvent event) { }

	@FXML
	void onMemory_Pressed(ActionEvent event) { }

	@FXML
	void onPowerSupply_Pressed(ActionEvent event) { }

	@FXML
	void onCase_Pressed(ActionEvent event) { }

	@FXML
	void onDevices_Pressed(ActionEvent event) { }

	@FXML
	void addProduct(ActionEvent event) { }

	@FXML
	void changeCuantity(ActionEvent event) { }

	@FXML
	void removeProduct(ActionEvent event) { }

	@FXML
	void changePrice(ActionEvent event) { }

	@FXML
	void applyDiscounts(ActionEvent event) { }

	@FXML
	void applyTaxes(ActionEvent event) { }

	@FXML
	void onPayAction(ActionEvent event) { }

	
	// SHOW VIEW
	public BorderPane getView() {
		return view;
	}
}
