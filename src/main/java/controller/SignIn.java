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
		/**
		 response.setContentType("application/json");
		 response.setHeader("Access-Control-Allow-Origin", "*"); 
		 response.setHeader("Access-Control-Allow-Credentials", "true");
		 response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		 response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
	    
		
		PrintWriter pw = response.getWriter();
		pw.println(JSonConverter.objectToJson(new Reponse("ok", "")));
		pw.flush();
*/

	   //creation de la reponse
   StringBuffer sb = new StringBuffer();
   sb.append("<HTML>\n");
   sb.append("<HEAD>\n");
   sb.append("<TITLE>Bonjour</TITLE>\n");
   sb.append("</HEAD>\n");
   sb.append("<BODY>\n");
   sb.append("<H1>Bonjour</H1>\n");
   sb.append("</BODY>\n");
   sb.append("</HTML>");
   
   // envoi des infos de l'en-tete
   response.setContentType("text/html");
   response.setContentLength(sb.length());
   
   // envoi de la réponse
   response.getOutputStream().print(sb.toString());
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
