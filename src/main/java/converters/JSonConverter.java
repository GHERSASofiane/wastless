package converters;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JSonConverter {

	private static Gson gson;
	static{	gson = new Gson();}
	
	
	public static JsonObject objectToJson(Object o)
	{
		String res = gson.toJson(o);
		JsonParser parser = new JsonParser();
		return (JsonObject) parser.parse(res);
	}
	
	
	
}
