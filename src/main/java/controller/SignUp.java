package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import emailOperations.EmailVerification;
import helpers.Readers;
import models.Personne;

import services.ProfileService;
import status.Reponse;
import tokens.AutorisationAcess;

/**
 * Servlet implementation class SignUp
 */
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JsonObject jsObj = Readers.getJSONfromRequest(request);
		 
		 Personne personne = new Personne();
		 personne = (Personne) JSonConverter.objectFromJson(jsObj, personne);
		  
		 JsonObject obj;
		 ProfileService pers = new ProfileService();
		 obj = pers.inscription( personne);
		 
		PrintWriter pw = response.getWriter();
		
		
		
		
		pw.println(obj);
		pw.flush();
		
	}

}
