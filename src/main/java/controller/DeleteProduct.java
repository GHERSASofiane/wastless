package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProductService; 

public class DeleteProduct  extends HttpServlet {
	public DeleteProduct() { }
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();
        
        int idProduct = (Integer) req.getAttribute("idProduct");
        
        // Préparer la répense
        ProductService rep = new ProductService();
        // Envoie de réponse 
        resp.println(rep.deleteProduct(idProduct)); 
        resp.flush();
	}
}
