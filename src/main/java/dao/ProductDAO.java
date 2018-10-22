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
import javax.servlet.http.HttpServletRequest;
import models.*;
import status.Reponse;

public class ProductDAO {

    private Connection db;

    public Reponse searchProduct(String nameArticle, int page) {
        List<Product> res = new ArrayList();
        Product tmp;
        try {
            db = Connexion.getConnection();
            Statement stmt = db.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Product, Users WHERE ProductStatus = 0 AND Product.UserId = Users.UserId AND ( ProductName LIKE '%" + nameArticle + "%' AND ProductName LIKE " + nameArticle + "%' AND ProductName LIKE " + nameArticle + " ) ORDER BY ProductDate OFFSET " + (page * 10) + " LIMIT 10 ");
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

                stmt.close();
                db.close();
            }
        } catch (URISyntaxException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        } catch (SQLException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        }
        return new Reponse("ok", res);
    }

    public Reponse addProduct(HttpServletRequest request) {
 
//        String ProductName, 
//               ProductDate, 
//               ProductDescription, 
//               ProductPicture, 
//               UserName, 
//               ProductPrice
//        int ProductId, 
//            ProductStatus, 
//            UserId
//        try {
//            db = Connexion.getConnection();
//            String res = "insert into Product(productName, productDescription, productPrice, productStatus, userId, productDate) values(?,?,?,?,?);";
//
//            PreparedStatement pst = db.prepareStatement(res);
//            pst.setString(1, productName);
//            pst.setString(2, productDescription);
//            pst.setDouble(3, productPrice);
//            pst.setInt(4, productStatus);
//            pst.setInt(5, userId);
//            pst.setString(6, productDate);
//
//            ResultSet rs = pst.executeQuery();
//
//            pst.close();
//            rs.close();
//            db.close();
//
//        } catch (URISyntaxException e) {
//            return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
//        } catch (SQLException e) {
//            return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
//        }
//=======
//      //  String ProductName;
//     //   String     ProductDate;
//     //   String ProductDescription;
//       // String ProductPicture;
//     //   String UserName;
//      //  String      ProductPrice;
//     //   int ProductId;
//     //   int   ProductStatus;
//     //   int   UserId;
//     //   try {
//      //      db = Connexion.getConnection();
//        //        String res = "insert into product(productName, productDescription, productPrice, productStatus, userId, productDate) values(?,?,?,?,?);";
//
//        //        PreparedStatement pst = db.prepareStatement(res);
//        //       pst.setString(1, productName);
//        //      pst.setString(2, productDescription);
//        //      pst.setDouble(3, productPrice);
//        //      pst.setInt(4, productStatus);
//        //      pst.setInt(5, userId);
//        //      pst.setString(6, productDate);
//
//        //      ResultSet rs = pst.executeQuery();
//
//        //     pst.close();
//        //     rs.close();
//        //    db.close();
//
//        //   } catch (URISyntaxException e) {
//        //       return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
//        //   } catch (SQLException e) {
//        //      return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
//        //  }
//>>>>>>> 1024ff1f81c4461a2d6331e4966332feaad5111a

        return new Reponse("ok", "votre produit est ajouté avec succes");

    }

    public Reponse deleteProduct(String productName, double productPrice, int userId) {
        try {
            db = Connexion.getConnection();
            String res = "insert into Product(productName, productDescription, productPrice, productStatus, userId, productDate) values(?,?,?,?,?);";

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
        ProductDetail tmpProd = new ProductDetail();
        
        try {
            db = Connexion.getConnection();
            
             Statement stmt = db.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Product, Users WHERE Product.userid = Users.userid AND ProductId = "+productId+";");
          while (rs.next()) {
              
            tmpProd.setProductName(rs.getString("ProductName"));  
            tmpProd.setProductDate(rs.getString("ProductDate"));  
            tmpProd.setProductDescription(rs.getString("ProductDescription"));  
            tmpProd.setProductPicture(rs.getString("ProductPicture"));
            tmpProd.setProductId(rs.getInt("ProductId"));  
            tmpProd.setProductPrice(rs.getString("ProductPrice"));  
            tmpProd.setProductStatus(rs.getInt("ProductStatus"));  
            tmpProd.setUserId(rs.getInt("UserId"));  
            tmpProd.setUserName(rs.getString("UserName")); 
            tmpProd.setUserMail(rs.getString("UserMail")); 
            tmpProd.setUserAdress(rs.getString("UserAdress"));  
            tmpProd.setUserPhone(rs.getInt("UserPhone")); 
            
          } 
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        } catch (SQLException e) {
            return new Reponse("ko", "Erreur sur le serveur");
        }
        
        return new Reponse("ok", tmpProd);
        
    }

    public Reponse validateProduct(String productId) {

        try {
            db = Connexion.getConnection();
            Statement pst = db.createStatement();

            pst.executeQuery(" UPDATE Product Set productStatus = 2 WHERE productId = " + productId + ";");

            pst.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "error !!! couldn't validate purchase");
        } catch (SQLException e) {
            return new Reponse("ko", "error !!! couldn't validate purchase");
        }

        return new Reponse("ok", "your purchase has been validated ");
    }

	public Reponse bookProduct(String productId,String productName) {
        try {
            db = Connexion.getConnection();
            String req = "INSERT INTO Booking" + "(bookingDated,productId,userId) VALUES(?,?,?)";
            PreparedStatement pst = db.prepareStatement(req);
            pst.setString(1, "");
            pst.setInt(2, Integer.parseInt(productId));
            pst.setString(3, productName);
            
           
            pst.executeUpdate();
           

            pst.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "an error has occured");
        } catch (SQLException e) {
            return new Reponse("ko", "an error has occured");
        }

        return new Reponse("ok", "the product has been reserved");
	}

	public Object cancelReservation(String productId) {


        try {
            db = Connexion.getConnection();
            Statement pst = db.createStatement();
            Statement delete = db.createStatement();
            
            pst.executeQuery(" UPDATE Product Set productStatus = 0 WHERE productId = " + productId + ";");
            delete.executeQuery(" DELETE FROM Booking  WHERE productId = " + productId + ";");
            
            delete.close();
            pst.close();
            db.close();

        } catch (URISyntaxException e) {
            return new Reponse("ko", "error !!! Can not cancel reservation");
        } catch (SQLException e) {
            return new Reponse("ko", "error !!! Can not cancel reservation");
        }

        return new Reponse("ok", "your booking has been canceled ");

	}
}
