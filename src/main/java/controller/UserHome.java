package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

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
	
		
	Enumeration<String> headers = request.getHeaderNames();
	
	while(headers.hasMoreElements())
	{
		String header = headers.nextElement();
		System.out.println(header + " --------------------> " + request.getHeader(header));
	}
			
		
	PrintWriter pw = response.getWriter();	
	JsonObject obj = new JsonObject();
	
	if(!AutorisationAcess.allowUser(request))
	{
		obj = JSonConverter.objectToJson(new Reponse("ko", "user not logged in"));
	}
	else
	{
		Claim claim = AutorisationAcess.verify(request);
		Reponse rep = new Reponse("ok", JSonConverter.objectToJson(claim));
		obj = JSonConverter.objectToJson(rep);
	}
		
	
	pw.println(obj);
	pw.flush();
	}

	

}
