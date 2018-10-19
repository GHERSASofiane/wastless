/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import services.ProductService;

/**
 *
 * @author ghersa
 */
public class AddProduct  extends HttpServlet {

    public AddProduct() { }
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

        // Préparer la répense
        ProductService rep = new ProductService();
        // Envoie de réponse
        resp.println(rep.addProduct(request));
        resp.flush();

    }
    
}
