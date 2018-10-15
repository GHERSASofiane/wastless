package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.SignUpDAO;
import models.Personne;
import status.Reponse;

public class SignUpService {

	
	
	public JsonObject inscription(Personne personne)
	{
	SignUpDAO suDAO = new SignUpDAO();
	Reponse reponse = suDAO.signUp(personne);
	JsonObject res = JSonConverter.objectToJson(reponse);
	
	
	return res;
	}
}
