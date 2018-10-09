package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Dessert extends HttpServlet {


    public Dessert() {  }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   response.setContentType("application/json");
		 response.setHeader("Access-Control-Allow-Origin", "*"); 
		 response.setHeader("Access-Control-Allow-Credentials", "true");
		 response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
	    
		
		PrintWriter pw = response.getWriter();
		pw.println(JSonConverter.objectToJson(new Reponse("ok", "")));
		pw.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
