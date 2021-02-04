package dad.javafx.owncomputer.welcome;

import dad.javafx.owncomputer.main.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	private static Stage primaryStage;
	
	private WelcomeController welcomeController;
	private MainController mainController;
	
	private static Scene welcomeScene;
	private static Scene mainScene;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		App.primaryStage = primaryStage;
		
		mainController = new MainController();
		welcomeController = new WelcomeController();
		
		mainScene = new Scene(mainController.getView());
		welcomeScene = new Scene(welcomeController.getView());
		
		primaryStage.setScene(welcomeScene);
		primaryStage.setTitle("¡Welcome to OwnComputerTPV!");
		primaryStage.getIcons().add(new Image("/images/owncomputer-icon.png"));
		primaryStage.setResizable(false);
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
	
}
