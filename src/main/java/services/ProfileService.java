package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProfileDAO;
import models.Personne;
import status.Reponse;
import tokens.AutorisationAcess;

public class ProfileService {
	
	
	
	public JsonObject getUserInformation( Personne personne)
	{
		ProfileDAO siDAO = new ProfileDAO();
		Reponse reponse = siDAO.logIn(personne);
		
		if(reponse.getStatus().equals("ok"))
		{
			JsonObject res = JSonConverter.objectToJson(reponse);
			String token = AutorisationAcess.registerToken(personne);
			res.addProperty("token", token);
			return res;
		}
		
		JsonObject res = JSonConverter.objectToJson(reponse);
		
		
		return res;
		
	}
	
	public JsonObject inscription( Personne personne)
	{
	ProfileDAO suDAO = new ProfileDAO();
	Reponse reponse = suDAO.signUp(personne);
	
	if(reponse.getStatus().equals("ok"))
	{
		JsonObject res = JSonConverter.objectToJson(reponse);
		String token = AutorisationAcess.registerToken(personne);
		res.addProperty("token", token);
		return res;
	}
	
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
	
	
	public JsonObject forgotMail(String email)
	{
	ProfileDAO pdao= new ProfileDAO();
	Reponse reponse = pdao.forgotMail(email);
	JsonObject res = JSonConverter.objectToJson(reponse);
	return res;
	}
}
