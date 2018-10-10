package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OfferSearch  extends HttpServlet {
    
    public OfferSearch() { }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {


            out.println("{");
            out.println("\"First Name\": \"Devesh\",");
            out.println("\"Last Name\": \"Sharma\"");
            out.println("}");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // envoi de la réponse
        response.getOutputStream().print(out);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}