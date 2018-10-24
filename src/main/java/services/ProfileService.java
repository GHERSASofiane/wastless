package services;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProfileDAO;
import models.Personne;
import status.Reponse;

public class ProfileService {
	
	
	
	public JsonObject getUserInformation( Personne personne)
	{
		ProfileDAO siDAO = new ProfileDAO();
		Reponse reponse = siDAO.logIn(personne);
		
		
		
		JsonObject res = JSonConverter.objectToJson(reponse);
		
		
		return res;
		
	}
	
	public JsonObject inscription( Personne personne)
	{
	ProfileDAO suDAO = new ProfileDAO();
	Reponse reponse = suDAO.signUp(personne);
	
	
	
	JsonObject res = JSonConverter.objectToJson(reponse);
	return res;
	}
	
	public JsonObject editProfile(Personne personne)
	{
	ProfileDAO pdao= new ProfileDAO();
	Reponse reponse = pdao.editProfile(personne);
	JsonObject res = JSonConverter.objectToJson(reponse);
	return res;
	}

}
