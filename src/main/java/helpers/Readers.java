package helpers;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Readers {

	
	public static JsonObject getJSONfromRequest(HttpServletRequest request)
	{
		StringBuffer jb = new StringBuffer();
		  String line = null;
		  try {
		    BufferedReader reader = request.getReader();
		    while ((line = reader.readLine()) != null)
		      jb.append(line);
		  } catch (Exception e) { /*report an error*/ }

		 JsonParser parser = new JsonParser();
		 JsonObject jsObj =  (JsonObject) parser.parse(jb.toString());
		 
		 return jsObj;
	}
}
