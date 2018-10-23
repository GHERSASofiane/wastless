package services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProfileDAO;
import models.Personne;
import status.Reponse;

public class ProfileService {
	
	
	
	public JsonObject getUserInformation(HttpServletRequest request, Personne personne)
	{
		ProfileDAO siDAO = new ProfileDAO();
		Reponse reponse = siDAO.logIn(personne);
		
		if(reponse.getStatus().equals("ok"))
		{
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*10);
		session.setAttribute("user", reponse.getReponse());
		}
		
		JsonObject res = JSonConverter.objectToJson(reponse);
		
		
		return res;
		
	}
	
	public JsonObject inscription(HttpServletRequest request, Personne personne)
	{
	ProfileDAO suDAO = new ProfileDAO();
	Reponse reponse = suDAO.signUp(personne);
	
	if(reponse.getStatus().equals("ok"))
	{
	HttpSession session = request.getSession();
	session.setMaxInactiveInterval(60*10);
	session.setAttribute("user", reponse.getReponse());
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

}
