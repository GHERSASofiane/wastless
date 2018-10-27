package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProductServices;

 
public class ProductSearch extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearch() {
        super(); 
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

// recuperer les params
        String PName = request.getParameter("ProductName");
        String Page = request.getParameter("Page");
        if (PName == null) {
            PName = "";
        }
        if (Page == null) {
            Page = "0";
        }

        PName = PName.toLowerCase();
        Page = Page.toLowerCase();
        int p = Integer.parseInt(Page);

        // Préparer la répense
        ProductServices rep = new ProductServices();
        // Envoie de réponse
        resp.println(rep.searchProduct(PName, p));
        resp.flush();
    }

}
