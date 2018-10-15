package services;


import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.SignInDAO;
import models.Personne;
import status.Reponse;


public class SignInService {

	
	
	public JsonObject getUserInformation(Personne personne)
	{
		SignInDAO siDAO = new SignInDAO();
		Reponse reponse = siDAO.logIn(personne);
		JsonObject res = JSonConverter.objectToJson(reponse);
		
		
		return res;
		
	}
}
