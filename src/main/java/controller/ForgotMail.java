package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ProfileService;

/**
 * Servlet implementation class ForgotMail
 */
public class ForgotMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userMail = request.getParameter("userMail");
		
		ProfileService ps = new ProfileService();
		JsonObject result = ps.forgotMail(userMail);
		
		PrintWriter resp = response.getWriter();
        resp.println(result);
        resp.flush();
		
	}

}
