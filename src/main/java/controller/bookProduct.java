package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ProductService;

public class bookProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public bookProduct() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter(); //can send character text to the client

	        //Récupération de paramètre 
	        String productId = request.getParameter("ProductId");
	        String userId = request.getParameter("userId");
	        productId = productId.toLowerCase();
	        userId = userId.toLowerCase();
	       
	        ProductService product = new ProductService();
	        JsonObject obj = product.bookProduct(productId,userId); 
	       
	        out.println(obj);
	        out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
