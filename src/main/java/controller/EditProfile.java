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
import models.Personne;
import services.ProfileService;
import tokens.AutorisationAcess;

/**
 * Servlet implementation class EditProfile
 */
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JsonObject jsObj = Readers.getJSONfromRequest(request);
		 
		 Personne personne = new Personne();
		 personne = (Personne) JSonConverter.objectFromJson(jsObj, personne);
		  
		ProfileService pers = new ProfileService();
		JsonObject obj = pers.editProfile(personne);
				 
		PrintWriter pw = response.getWriter();
		
		String token = AutorisationAcess.registerToken(personne);
		obj.addProperty("token", token);
		pw.println(obj);
		pw.flush();
	}

}
