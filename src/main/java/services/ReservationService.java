package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ReservationDAO;
import status.Reponse;



public class ReservationService {

	
	
	public JsonObject reserver(int productId, int userId)
	{
		ReservationDAO resDAO = new ReservationDAO();
		Reponse reponse = resDAO.reserver(productId, userId);
		JsonObject res = JSonConverter.objectToJson(reponse);
		
		
		return res;
	}
}
