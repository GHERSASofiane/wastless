package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ProductService;

/**
 * Servlet implementation class ValidateProduct
 */
public class ValidateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateProduct() {    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    PrintWriter out = response.getWriter(); //can send character text to the client

        //Récupération de paramètre 
        String productId = request.getParameter("ProductId"); 
        productId = productId.toLowerCase();
        
       ProductService product = new ProductService();
       JsonObject obj = product.validateProduct(productId); 
       
        out.println(obj);
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
