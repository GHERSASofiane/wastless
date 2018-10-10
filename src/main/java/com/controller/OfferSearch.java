package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import com.beans.*;

public class OfferSearch  extends HttpServlet {
    
    public OfferSearch() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();



        EnsembleOffer ensOff = new EnsembleOffer("Iphone");
       // System.out.println(ensOff.toString());

        //    out.println("{");
        //    out.println("\"First Name\": \"Devesh\",");
        //     out.println("\"Last Name\": \"Sharma\"");
            out.println(ensOff.toString());
            out.close();


        // envoi de la réponse
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}