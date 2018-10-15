package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ProductService;


public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductDetail() {
        super();
          }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    PrintWriter out = response.getWriter(); //can send character text to the client

        //Recuperate productId in url
        String productId = request.getParameter("ProductId"); 
        productId = productId.toLowerCase();
        
        ProductService product = new ProductService();
        JsonObject obj = product.getProductDetails(productId); 
        
         out.println(obj);
         out.close();
 	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
