package dad.javafx.owncomputer.budget;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dad.javafx.owncomputer.main.MainController;
import dad.javafx.owncomputer.model.Component;
import dad.javafx.owncomputer.main.App;


public class BudgetDataProvider {
	
public static List<Component> getAllProducts() {
		
		Random rnd = new Random();
		
		List<Component> things = new ArrayList<>();
		
//		for (long i = 1; i <= App.getMainController().get; i++) {
//			
//			Component oneProduct = new Component();
//			oneProduct.setName("Name Product " + i);
//			oneProduct.setPrice("Price " + i);
//			oneProduct.add(oneProduct);
//			
//		}
		
		return things;
	}

}
