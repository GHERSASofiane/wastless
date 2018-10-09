package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import services.PersonneService;
import status.Reponse;
import converters.JSonConverter;

/**
 * Servlet implementation class SignIn
 */
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println(JSonConverter.objectToJson(new Reponse("ok", "")));
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 JsonObject o = JSonConverter.objectToJson(request.getReader());
		  
		 String name = o.get("name").getAsString();
		 String password = o.get("password").getAsString();
		 
		 PersonneService ps = new PersonneService();
		 JsonObject obj = ps.getUserInformation(name, password);
		 
	
		 PrintWriter pr = response.getWriter();
		 
		 pr.println(obj);
		 pr.flush();
		 
    	
		
	}

}
