package apiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.JsonObject;

import converters.JSonConverter;

public class PriceYuge {

	private final static String url_api = "https://price-api.datayuge.com/api/v1/compare/";
	private final static String apiKey = "6ot45T5iehVXKizmj23rbyatgifuj1jUaxu";
	
	public static String getResult(String uri)
	{
		URL url;
		String output = "";
		try {
			url = new URL(uri);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
	
		InputStream xml = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(xml));

			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
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
		
		return output;
	}
	
	public static JsonObject listCategories()
	{
	
		String uri = url_api + "list/categories?api_key="+ apiKey + "&page=1";
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	public static JsonObject searchProduct(String productName)
	{
		String uri = url_api + "search?api_key="+ apiKey + "&product="+productName;
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	public static JsonObject detail(String productId)
	{
		String uri = url_api + "detail?api_key="+ apiKey + "&id="+productId;
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	public static JsonObject specs(String productId)
	{
		String uri = url_api + "specs?api_key="+ apiKey + "&id="+productId;
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	public static JsonObject productImage(String productId)
	{
		String uri = url_api + "images?api_key="+ apiKey + "&id="+productId;
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	public static JsonObject productPrices(String productId)
	{
		String uri = url_api + "price?api_key="+ apiKey + "&id="+productId;
		return JSonConverter.objectToJson(getResult(uri));
	}
	
	
	
	
	
	/**
	public static void main(String[] args) {
		PriceYuge.listCategories();
		System.out.println("----------------- search -------------------------");
		PriceYuge.searchProduct("sony");
		System.out.println("----------------- detail -------------------------");
		PriceYuge.detail("ZToxMjIyNA");
	}
	*/
}
