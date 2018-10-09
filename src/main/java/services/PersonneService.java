package services;


import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.PersonneDAO;
import status.Reponse;


public class PersonneService {

	
	
	public JsonObject getUserInformation(String name, String password)
	{
		PersonneDAO personne = new PersonneDAO();
		Reponse rep = personne.logIn(name, password);
		return JSonConverter.objectToJson(rep);
		
		
	}
}
