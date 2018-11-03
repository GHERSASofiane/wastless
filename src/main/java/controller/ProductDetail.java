package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProductServices;

public class ProductDetail extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ProductDetail() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récuperer le PrintWriter Pour envoyer la réponse
        PrintWriter resp = response.getWriter();

        // recuperer les params
        String ProductId = request.getParameter("ProductId");
        if (ProductId == null) {
            ProductId = "";
        }
        int p = Integer.parseInt(ProductId); 

        // Préparer la répense
        ProductServices rep = new ProductServices();
        // Envoie de réponse
        resp.println(rep.getProductDetails(p));
        resp.flush();

    }

}
