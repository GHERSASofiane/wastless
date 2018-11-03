package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;

import com.google.gson.JsonObject;

import apiService.PriceYuge;


/**
 * Servlet implementation class ComparePrice
 */
public class ComparePrice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComparePrice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productName = request.getParameter("productName");
		
		JsonObject obj = PriceYuge.searchProduct(productName);
		JsonArray data = obj.getAsJsonArray("data");
		JsonArray result = new JsonArray();
		
		for(int i = 0; i < 10; i++)
		{
			
			JsonObject product = data.get(i).getAsJsonObject();
			if(product.get("product_name").getAsString().contains(productName) && product.get("can_compare").getAsBoolean())
			{
				JsonObject prices = PriceYuge.productPrices(product.get("product_id").getAsString());
				product.add("prices", prices);
				result.add(product);
			}
			
			 
			
		}
		
		PrintWriter resp = response.getWriter();
        resp.println(result);
        resp.flush();
		
		
	}
	

	
	
		
	
}
