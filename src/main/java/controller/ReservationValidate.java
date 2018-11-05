package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import helpers.Readers;
import models.Reservation;
import services.ProductServices; 

public class ReservationValidate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ReservationValidate() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récuperer le PrintWriter Pour envoyer la réponse
		PrintWriter resp = response.getWriter();

		JsonObject jsObj = Readers.getJSONfromRequest(request);

		Reservation reserv = new Reservation();
		reserv = (Reservation) JSonConverter.objectFromJson(jsObj, reserv);

		// Préparer la réponse
		ProductServices rep = new ProductServices();
		// Envoie de réponse
		resp.println(rep.ReservationValidate(reserv));  
		resp.flush();

	}
}
