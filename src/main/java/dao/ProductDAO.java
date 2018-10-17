package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.Connexion;
import java.util.ArrayList;
import java.util.List;
import models.Product;
import status.Reponse;

public class ProductDAO {

    private Connection db;

    public Reponse searchProduct(String nameArticle, int page) {
        List<Product> res = new ArrayList();
        Product tmp;
        try {
            db = Connexion.getConnection();
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product, Users WHERE ProductStatus = 0 AND Product.UserId = Users.UserId AND ProductName LIKE '%" + nameArticle + "%' ORDER BY ProductDate OFFSET " + (page * 10) + " LIMIT 10 ");
            while (rs.next()) {
                tmp = new Product();

                tmp.setProductName(rs.getString("ProductName"));
                tmp.setProductDate(rs.getString("ProductDate"));
                tmp.setProductDescription(rs.getString("ProductDescription"));
                tmp.setProductPicture(rs.getString("ProductPicture"));
                tmp.setProductId(rs.getInt("ProductId"));
                tmp.setProductPrice(rs.getString("ProductPrice"));
                tmp.setProductStatus(rs.getInt("ProductStatus"));
                tmp.setUserId(rs.getInt("UserId"));
                tmp.setUserName(rs.getString("UserName"));

                res.add(tmp);
            }
        } catch (URISyntaxException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        } catch (SQLException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        }
        return new Reponse("ok", res);
    }

    public Reponse addProduct(int productId, String productName, String productDescription, double productPrice, int productStatus, int userId, String productDate) {

        try {
            db = Connexion.getConnection();
            String res = "insert into product(productName, productDescription, productPrice, productStatus, userId, productDate) values(?,?,?,?,?);";

            PreparedStatement pst = db.prepareStatement(res);
            pst.setString(1, productName);
            pst.setString(2, productDescription);
            pst.setDouble(3, productPrice);
            pst.setInt(4, productStatus);
            pst.setInt(5, userId);
            pst.setString(6, productDate);

            ResultSet rs = pst.executeQuery();

            pst.close();
            rs.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
        } catch (SQLException e) {
            return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
        }

        return new Reponse("ok", "votre produit est ajouté avec succes");

    }

    public Reponse deleteProduct(String productName, double productPrice, int userId) {
        try {
            db = Connexion.getConnection();
            String res = "insert into product(productName, productDescription, productPrice, productStatus, userId, productDate) values(?,?,?,?,?);";

            PreparedStatement pst = db.prepareStatement(res);
            pst.setString(1, productName);
            pst.setDouble(2, productPrice);
            pst.setInt(3, userId);

            ResultSet rs = pst.executeQuery();

            pst.close();
            rs.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "votre produit n'a pas pu être suprimmer");
        } catch (SQLException e) {
            return new Reponse("ko", "votre produit n'a pas pu être suprimmer");
        }

        return new Reponse("ok", "votre produit est supprimé avec succes");

    }

    public Reponse getProductDetails(String productId) {
        Product product = new Product();
        try {
            db = Connexion.getConnection();
            Statement pst = db.createStatement();

            ResultSet rs = pst.executeQuery(("select * from product where productId=" + productId + ";"));

            while (rs.next()) {
                product.setProductName(rs.getString(2));
                product.setProductDescription(rs.getString(3));
                product.setProductPrice(rs.getString(4));
                product.setProductStatus(rs.getInt(6));
                product.setProductDate(rs.getString(8));
            }

            pst.close();
            rs.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "Sorry !!! can not download product details");
        } catch (SQLException e) {
            return new Reponse("ko", "Sorry !!! can not download product details");
        }

        return new Reponse("ok", product);

    }

    public Reponse validateProduct(String productId) {

        try {
            db = Connexion.getConnection();
            Statement pst = db.createStatement();

            pst.executeQuery(" UPDATE product Set productStatus = 2 WHERE productId = " + productId + ";");

            pst.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "error !!! couldn't validate purchase");
        } catch (SQLException e) {
            return new Reponse("ko", "error !!! couldn't validate purchase");
        }

        return new Reponse("ok", "your purchase has been validated ");
    }

}
