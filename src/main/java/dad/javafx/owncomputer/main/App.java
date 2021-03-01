package dad.javafx.owncomputer.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class is used to show the view
 * @author Melania, Alexis, Ayoze & Aarón
 * @version 01/02/2021
 * @see <a href = "https://github.com/dam-dad/OwnComputerTPV" /> OwnComputer Github </a>
 */

public class App extends Application {

	private static Stage primaryStage;
	
	private static MainController mainController;
	
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage = primaryStage;
		
		mainController = new MainController();
		
		mainScene = new Scene(mainController.getView());
		
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("¡Welcome to OwnComputerTPV!");
		primaryStage.getIcons().add(new Image("/images/owncomputer-icon.png"));
		primaryStage.show();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void goToOwnComputer() {
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("OwnComputerTPV");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static MainController getMainController() {
		return mainController;
	}
	
	
	
}
