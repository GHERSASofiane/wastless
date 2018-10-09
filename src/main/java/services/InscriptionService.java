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
		Reponse rep = insc.incription(personne);

		return JSonConverter.objectToJson(rep);
		
		
	}
	
}
