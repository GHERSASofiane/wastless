package controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthScrollBarUI;

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
		
		JsonArray result = PriceYuge.getPricesOfAllProducts(productName);
		
		PrintWriter resp = response.getWriter();
        resp.println(result);
        resp.flush();
		
		
	}
	

	
	
		
	
}
