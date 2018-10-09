package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import models.Personne;
import services.InscriptionService;


/**
 * Servlet implementation class InscriptionController
 */
public class InscriptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionController() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject o = JSonConverter.objectToJson(request.getReader());
		  
		 String userMail = o.get("userMail").getAsString();
		 String userName = o.get("userName").getAsString();
		 String userPassword = o.get("userPassword").getAsString();
		 String userPhone = o.get("userPhone").getAsString();
		 String userAdress = o.get("userAdress").getAsString();
	 
		 Personne personne = new Personne();
		 personne.setUsermail(userMail);
		 personne.setUsername(userName);
		 personne.setUserpassword(userPassword);
		 personne.setUserphone(userPhone);
		 personne.setUseradresse(userAdress);
		 
		 
		 
		InscriptionService ins = new InscriptionService();
		 JsonObject obj = ins.getInscriptionStatus(personne);		 
	
		 PrintWriter pr = response.getWriter();
		 
		 pr.println(obj);
		 pr.flush();
	}

}
