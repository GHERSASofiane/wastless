package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import services.ProductService;

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
        ProductId = ProductId.toLowerCase();

        // Préparer la répense
        ProductService rep = new ProductService();
        // Envoie de réponse
        resp.println(rep.getProductDetails(ProductId));
        resp.flush();

    }

}
