package com.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.*;
/**
 *
 * @author ghersa
 */
public class OfferConsult  extends HttpServlet {

    public OfferConsult() { }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // recuperer les params
        String ProductId = request.getParameter("ProductId"); 
         
        // appeler le model
        OfferConsultModel Off = new OfferConsultModel(ProductId);
 
        // envoie la réponse au client
        out.println("Off.toString()");
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}