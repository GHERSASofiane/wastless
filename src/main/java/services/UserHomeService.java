package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.UserReservationDAO;

public class UserHomeService {

	
	public JsonObject getUserReservation(int userId)
	{
		UserReservationDAO urd = new UserReservationDAO();
		return JSonConverter.objectToJson(urd.getUserReservation(userId));
	}
	
}
