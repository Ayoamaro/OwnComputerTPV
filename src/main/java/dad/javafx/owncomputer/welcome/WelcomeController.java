package dad.javafx.owncomputer.welcome;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import dad.javafx.util.DBUtils;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WelcomeController implements Initializable {
	
	// MODEL
	private Model model = new Model();
	private ArrayList<String> linesCSV = new ArrayList<>();
	
	// VIEW
	@FXML
	private GridPane view;
	@FXML
	private Button loginBTN, resetBTN;
	@FXML
	private TextField userTXT;
	@FXML
	private PasswordField pswdTXT;
	

	// CONSTRUCTOR
	public WelcomeController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Welcome.fxml"));
		loader.setController(this);
		loader.load();
	}

	// INITIALIZE
	@Override
	public void initialize(URL location, ResourceBundle resources) { 
		DBUtils.readUsersFile(linesCSV);
		
		Bindings.bindBidirectional(userTXT.textProperty(), model.userProperty());
		Bindings.bindBidirectional(pswdTXT.textProperty(), model.pswdProperty());
	}
	
	@FXML
	void onLogin(ActionEvent event) { 
		Boolean verify = false;
		String md5Password = model.getPswd();
		String md5User = model.getUser();
		
		for (int i = 0; i < linesCSV.size(); i++) {
			String[] dataFile = linesCSV.get(i).split(",");
		    String userEach = dataFile[0];
		    String passEach = dataFile[1];

		    if (userEach.equals(md5User) && passEach.equals(md5Password)) { 
		    	verify = true; 
		    }
		}
		
		if (verify == true) { 
			App.goToOwnComputer(); 
		} else {
			DBUtils.wrongCredentials();
		}
	}
	
	@FXML
	void onReset(ActionEvent event) { 
		userTXT.setText("");
		pswdTXT.setText("");
	}
	
	// SHOW VIEW
	public GridPane getView() {
		return view;
	}
}
