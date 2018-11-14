package apiService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PriceAPI {

	
	private final static String url_job = "https://api.priceapi.com/v2/jobs";
	private final static String apiKey = "?token=ODQEYLHPDNKOOOBDNUJUXRBEXYSCNJTACSPGFNIZAUKYIKJRZJVEFGXCNDEOYRJR";
	private final static String url_product = "https://api.priceapi.com/products/bulk/";
	private final static String source = "&source=google_shopping";
	private final static String country = "&country=fr";
	private final static String topic = "&topic=product_and_offers";
	private final static String key = "&key=term";
	public static boolean isFinished = false;
	
	
	
	public static JsonElement connect(String uri, String methode)
	{
		URL url;
		StringBuilder output = new StringBuilder();
		
		try {
			url = new URL(uri);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(methode);
		connection.setRequestProperty("Accept", "application/json");
	
		InputStream is = connection.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line;
		
			
			while ((line = br.readLine()) != null) {
				output.append(line);
			}
		
		connection.disconnect();
		}
		 catch (Exception e) {
			e.printStackTrace();
		} 
		
		if(output.length() == 0)
			return new JsonObject();
		else
		{
		JsonParser parser = new JsonParser();
		JsonElement res =  parser.parse(output.toString());
		return res;
		}
		
		
	}
	
	
	
	public static JsonObject createNewJob(String productName)
	{
		
	
		isFinished = false;
		String uri =  url_job + apiKey + source + country + topic + key + "&values=" + productName;
		return (JsonObject) connect(uri, "POST");
		
		
	}
	
	
	public static JsonObject waitForFinish(String bulkId)
	{
		String uri = url_job + "/" + bulkId + apiKey;
		return connect(uri, "GET").getAsJsonObject();
	}
	
	
	
	 
	public static JsonObject searchProduct(String productName)
	{
		JsonObject bulk = createNewJob(productName).getAsJsonObject();
		String bulkId = bulk.get("job_id").getAsString();
		
		
		
		
		Boolean done = false;
	    while (!done) {
	      try {
	        Thread.sleep(5000);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	      JsonObject bulkStatus = waitForFinish(bulkId);

	      Boolean isComplete = false;
	      String status =  bulkStatus.get("status").getAsString();
	      isComplete = status.equals("finished");
	     
	      if (isComplete) {
	        done = true;
	      }
	    }
	    
		String status = bulk.get("status").getAsString();
		System.out.println("bulk id : " + bulkId + " status : " + status);
		String uri = url_product + bulkId + apiKey;
	
		
	//	String uri = url_product + "5bec6d267a4b2b169dee6eb6" + apiKey;
		
		return  connect(uri, "GET").getAsJsonObject();
		
	}
	
	
	public static String values(List<String> param)
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("value=");
		for(String p : param)
		{
			sb.append(p.replaceAll(" ", "%20") + "%0A");
		}
		
		
		if(sb.length() > 2)
			sb.delete(sb.length() - 3, sb.length() - 1);
		
		return sb.toString();
	}
	
}
