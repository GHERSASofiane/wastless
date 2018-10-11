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
public class OfferSearch  extends HttpServlet {
    
    public OfferSearch() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        // recuperer les params
        String PName = request.getParameter("ProductName");
        String Page = request.getParameter("Page"); 
        if( PName == null)  PName = "";
        if( Page == null) Page = "0";
         
        // appeler le model
        EnsembleOffer ensOff = new EnsembleOffer(PName, Page);
 
        // envoie la réponse au client
        out.println(ensOff.toString());
        out.close();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}