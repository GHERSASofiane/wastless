package apiService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class SchecduledTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(new Date() + " Execution de ma tache");
	/**	
		JsonObject obj = (JsonObject) PriceYuge.searchProduct("sony");
	
		
		JsonArray result = obj.getAsJsonArray("results");
		List<ProductPrices> productprices = new ArrayList<>();
		
		for(JsonElement ele : result)
		{
			JsonObject product = ele.getAsJsonObject().get("content").getAsJsonObject();
			ProductPrices ps = new ProductPrices();
			ps = (ProductPrices) JSonConverter.objectFromJson(product, ps);
			
			productprices.add(ps);
			System.out.println(ps.getName());
		}
		
		
		for(ProductPrices pPrices : productprices)
		{
			System.out.println("-------------" + pPrices.getName() + "-----------------");
			for(ProductStore offer : pPrices.getOffers())
			{
				System.out.println(" ---------" +  offer.getShop_name() + ", " + offer.getPrice());
			}
		}
		
		*/
		
	}

}
