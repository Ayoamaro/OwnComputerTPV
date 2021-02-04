package dad.javafx.owncomputer.welcome;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class WelcomeController implements Initializable {

	// VIEW
	@FXML
	private GridPane view;
	@FXML
	private Button loginBTN, resetBTN;
	@FXML
	private TextField usercodeTXT;
	

	// CONSTRUCTOR
	public WelcomeController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Welcome.fxml"));
		loader.setController(this);
		loader.load();
	}

	// INITIALIZE
	@Override
	public void initialize(URL location, ResourceBundle resources) { 
		/*usercodeTXT.textProperty().addListener((obs, oldText, newText) -> {
			loginBTN.setDisable(newText.isEmpty());
	    });
	    
	    ON FXML VIEW (loginBTN): disable="${usercodeTXT.text.empty}"
	    */
	}
	
	
	@FXML
	void onLogin(ActionEvent event) { 
		App.goToOwnComputer();
	}
	
	@FXML
	void onReset(ActionEvent event) { 
		usercodeTXT.setText("");
	}
	
	// SHOW VIEW
	public GridPane getView() {
		return view;
	}
}
