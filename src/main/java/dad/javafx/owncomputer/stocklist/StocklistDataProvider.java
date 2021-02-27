package dad.javafx.owncomputer.stocklist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StocklistDataProvider {
	
public static List<ProductList> getAllProducts() {
		
		Random rnd = new Random();
		
		List<ProductList> staff = new ArrayList<>();
		
		for (long i = 1; i <= 500; i++) {
			
			ProductList oneProduct = new ProductList();
//			oneProduct.setId(i);
//			oneProduct.setName("Name Product " + i);
//			oneProduct.setPrice("PRice " + i);
//			oneProduct.setCantidad(rnd.nextInt());
//			oneProduct.add(producto);
			
		}
		
		return staff;
	}

}
