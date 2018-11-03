 
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
import services.ProductServices; 

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
        ProductServices rep = new ProductServices();
        // Envoie de réponse 
        resp.println(rep.addProduct(product));  
        resp.flush();

    }
    
}
