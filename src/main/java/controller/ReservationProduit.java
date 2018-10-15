package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ReservationService;


/**
 * Servlet implementation class ReservationProduit
 */
public class ReservationProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationProduit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		ReservationService res = new ReservationService();
		JsonObject obj = res.reserver(productId, userId);
			
		PrintWriter pw = response.getWriter();
	
		
		pw.println(obj);
		pw.flush();
		
		
	}

	

}
