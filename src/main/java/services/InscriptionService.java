package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.InscriptionDAO;

import models.Personne;
import status.Reponse;

public class InscriptionService {

	public JsonObject getInscriptionStatus(Personne personne)
	{
		InscriptionDAO insc = new InscriptionDAO();
		boolean exist = insc.incription(personne);
		
		if(exist)
		{
			return JSonConverter.objectToJson(new Reponse("ok", ""));
		}
		
		return JSonConverter.objectToJson(new Reponse("ko", "there was an error, please try again !!!"));
		
		
	}
	
}
