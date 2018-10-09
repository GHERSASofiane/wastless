package services;


import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.PersonneDAO;
import models.Personne;


public class PersonneService {

	
	
	public JsonObject getUserInformation(String name, String password)
	{
		PersonneDAO personne = new PersonneDAO();
		Personne user = personne.logIn(name, password);
		JsonObject res = JSonConverter.objectToJson(user);
		return res;
		
	}
}
