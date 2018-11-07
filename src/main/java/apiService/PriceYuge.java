package apiService;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;





public class PriceYuge {

	private final static String url_api = "https://price-api.datayuge.com/api/v1/compare/";
	private final static String apiKey = "6ot45T5iehVXKizmj23rbyatgifuj1jUaxu";
	
	public static JsonObject getResult(String uri)
	{
		URL url;
		StringBuilder output = new StringBuilder();
		try {
			url = new URL(uri);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
	
		InputStream is = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		
			
			while ((line = br.readLine()) != null) {
				output.append(line);
			}
		
		connection.disconnect();
		}
		 catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		 } catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(output.length() == 0)
			return new JsonObject();
		else
		{
		JsonParser parser = new JsonParser();
		JsonObject res = (JsonObject) parser.parse(output.toString());
		return res;
		}
	}
	
	public static JsonObject listCategories()
	{
	
		String uri = url_api + "list/categories?api_key="+ apiKey + "&page=1";
		return getResult(uri);
	}
	 
	public static JsonObject searchProduct(String productName)
	{
		String uri = url_api + "search?api_key="+ apiKey + "&product="+productName+"&page=1";
		return getResult(uri);
		
	}
	
	public static JsonObject detail(String productId)
	{
		String uri = url_api + "detail?api_key="+ apiKey + "&id="+productId;
		return getResult(uri);
	}
	
	public static JsonObject specs(String productId)
	{
		String uri = url_api + "specs?api_key="+ apiKey + "&id="+productId;
		return getResult(uri);
	}
	
	public static JsonObject productImage(String productId)
	{
		String uri = url_api + "images?api_key="+ apiKey + "&id="+productId;
		return getResult(uri);
	}
	
	public static JsonObject productPrices(String productId)
	{
		String uri = url_api + "price?api_key="+ apiKey + "&id="+productId;
		return getResult(uri);
	}
	
	
	public static JsonObject getPrices(JsonObject tempObj)
	{
		JsonObject prices = PriceYuge.productPrices(tempObj.get("product_id").getAsString());
		
		JsonObject obj = new JsonObject();
		obj.addProperty("product_title", tempObj.get("product_title").getAsString());
		obj.add("prices", prices);
		
		System.out.println(obj);
		return obj;
	}
	
	
	public static JsonArray getPricesOfAllProducts(String productTitle)
	{
		JsonObject res = PriceYuge.searchProduct(productTitle);
		JsonArray data = (JsonArray) res.get("data");
		JsonArray result = new JsonArray();
		
		if(data != null)
		if(data.size() > 10)
			for(int i = 0; i<10; i++)
			{
				JsonObject tempObj = (JsonObject) data.get(i);	
				result.add(PriceYuge.getPrices(tempObj));
			}
		else
			for(JsonElement ele: data)
			{
				
				JsonObject tempObj = (JsonObject) ele;
				result.add(PriceYuge.getPrices(tempObj));
			}
		
		return result;
	}
	
	/**
	public static void main(String[] args) {
		PriceYuge.listCategories();
		System.out.println("----------------- search -------------------------");
		
		System.out.println(PriceYuge.getPricesOfAllProducts("sony"));
		
//		System.out.println("----------------- detail -------------------------");
//		PriceYuge.detail("ZToxMjIyNA");
	}
	*/
}
