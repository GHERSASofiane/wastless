package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import services.ProductServices; 

public class DeleteProduct  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteProduct() { super(); }
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();
        
        int idProduct =  Integer.parseInt(req.getParameter("idProduct"));
        
        // Préparer la répense
        ProductServices rep = new ProductServices();
        // Envoie de réponse 
        resp.println(rep.DeleteProduct(idProduct)); 
        resp.flush();
	}
}
