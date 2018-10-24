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

import com.google.gson.JsonObject;

import converters.JSonConverter;
import helpers.Readers; 
import models.Product;
import services.ProductService;
import status.Reponse; 

/**
 *
 * @author ghersa
 */
public class AddProduct  extends HttpServlet {

    public AddProduct() { }
    
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

        JsonObject jsObj = Readers.getJSONfromRequest(request);

        Product product = new Product();
        product = (Product) JSonConverter.objectFromJson(jsObj, product);
        
        // Préparer la répense
//        ProductService rep = new ProductService();
        // Envoie de réponse 
//        resp.println(rep.addProduct(product)); 
        resp.println(new Reponse("ok a sofiane : ", product.getProductName())); 
        resp.flush();

    }
    
}
