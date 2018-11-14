package apiService.backend;



import java.util.Date;
import java.util.List;
import java.util.TimerTask;


import com.google.gson.JsonObject;

import apiService.PriceAPI;



public class SchecduledTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(new Date() + " Execution de ma tache");
		getProductName.deleteProductsFromDB();
		List<String> productNames = getProductName.productNames();
		
		
		List<ProductPrices> productprices = getProductName.productFromAPI(PriceAPI.values(productNames));
		getProductName.insert(productprices);	
	}

}
