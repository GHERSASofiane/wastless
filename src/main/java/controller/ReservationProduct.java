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
import status.Reponse;


/**
 * Servlet implementation class ReservationProduit
 */
public class ReservationProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
    public ReservationProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */ 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

        JsonObject jsObj = Readers.getJSONfromRequest(request);
        
        Reservation reserv = new Reservation();
        reserv = (Reservation) JSonConverter.objectFromJson(jsObj, reserv);
        
		
        
        // Préparer la répense
        ProductServices rep = new ProductServices();
        new JSonConverter();
		// Envoie de réponse 
//        resp.println(rep.addProduct(reserv)); 
        resp.println(JSonConverter.objectToJson(new Reponse("ok", reserv)));  
        resp.flush();
		
		
	}

	

}
