package apiService.backend;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import apiService.PriceAPI;
import apiService.PriceYuge;
import converters.JSonConverter;


public class SchecduledTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(new Date() + " Execution de ma tache");
		List<String> productNames = getProductName.productNames();		
		JsonObject obj = (JsonObject) PriceAPI.searchProduct(PriceAPI.values(productNames));
		JsonArray result = obj.getAsJsonArray("results");
		List<ProductPrices> productprices = new ArrayList<ProductPrices>();
		
		for(JsonElement ele : result)
		{
			JsonObject product = ele.getAsJsonObject().get("content").getAsJsonObject();
			ProductPrices ps = new ProductPrices();
			ps = (ProductPrices) JSonConverter.objectFromJson(product, ps);	
			productprices.add(ps);
			System.out.println(ps.getName());
		}
		
		
		getProductName.insert(productprices);	
	}

}
