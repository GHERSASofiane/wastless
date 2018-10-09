package services;


import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.PersonneDAO;
import status.Reponse;


public class PersonneService {

	
	
	public JsonObject getUserInformation(String name, String password)
	{
		PersonneDAO personne = new PersonneDAO();
		boolean exist = personne.logIn(name, password);
		
		if(exist)
		{
			return JSonConverter.objectToJson(new Reponse("ok", ""));
		}
		
		return JSonConverter.objectToJson(new Reponse("ko", "user don't exist, verify your mail or password !!!"));
		
		
	}
}
