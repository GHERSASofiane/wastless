package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.interfaces.Claim;
import com.google.gson.JsonObject;

import converters.JSonConverter;
import services.UserHomeService;
import status.Reponse;
import tokens.AutorisationAcess;

/**
 * Servlet implementation class UserHome
 */
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Claim userId = AutorisationAcess.verify(request);
	JsonObject obj = new JsonObject();
	

	PrintWriter pw = response.getWriter();

	if(userId.asString().isEmpty())
	{
		obj = JSonConverter.objectToJson(new Reponse("ko", "user not logged in"));
	}
	else
	{
		int id = Integer.parseInt(userId.asString());
		UserHomeService uhs = new UserHomeService();
		obj = uhs.getUserReservation(id);
	}
	
	pw.println(obj);
	pw.flush();
	}

	

}
