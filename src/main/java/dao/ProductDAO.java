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
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM Product, Users WHERE ProductStatus = 0 AND Product.UserId = Users.UserId AND ProductName LIKE '%"
							+ nameArticle + "%' ORDER BY ProductDate DESC OFFSET " + (page * 10) + " LIMIT 10 ");

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
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			return new Reponse("ko", "Erreur sur le serveur");
		} catch (SQLException e) {
			return new Reponse("ko", "Erreur sur le serveur");
		}
		return new Reponse("ok", res);
	}

	public Reponse getProductDetails(String productId) {
		ProductDetail tmpProd = new ProductDetail();

		try {
			db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Product, Users WHERE Product.userid = Users.userid AND ProductId = "
							+ productId + ";");
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

	public Reponse bookProduct(String productId, String productName) {
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
// ******  Function fin   

	public Reponse addProduct(Product product) {

		try {
			db = Connexion.getConnection();
			String res = " INSERT INTO product(productname,productdescription,productprice,productpicture,productstatus,userid,productdate) VALUES('"
					+ product.getProductName() + "','" + product.getProductDescription() + "',"
					+ Integer.parseInt(product.getProductPrice()) + ",'" + product.getProductPicture() + "',0,"
					+ product.getUserId() + ",'" + product.getProductDate() + "');";
			Statement statement = db.createStatement();
			statement.executeUpdate(res);
			statement.close();

			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre ajouter");
		}

		return new Reponse("ok", " votre produit est ajouter avec succes ");

	}

	public Reponse EditProduct(Product product) {

		try {
			
			db = Connexion.getConnection();
			String query = " UPDATE product SET productname = '"+ product.getProductName() +"', productdescription = '"+ product.getProductDescription() +"', "
					+ " productprice = '"+ Integer.parseInt(product.getProductPrice()) +"', productpicture   = '"+ product.getProductPicture() +"' "
							+ " WHERE ProductId = "+ product.getProductId() ;
			
			PreparedStatement preparedStmt = db.prepareStatement(query);	
			preparedStmt.executeUpdate();
 
			preparedStmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre modifier ");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre modifier ");
		}

		return new Reponse("ok", " votre produit est modifier avec succes ");

	}

	public Reponse deleteProduct(int id) {
		try {

			db = Connexion.getConnection();
			String query = "DELETE FROM product WHERE productid = ?";
			PreparedStatement preparedStmt = db.prepareStatement(query);
			preparedStmt.setInt(1, id);

			// execute the prepared statement
			preparedStmt.execute();
			preparedStmt.close();
			db.close();
			

//			db = Connexion.getConnection();
//			query = "DELETE FROM booking WHERE productid = ?";
//			preparedStmt = db.prepareStatement(query);
//			preparedStmt.setInt(1, id);
//
//			// execute the prepared statement
//			preparedStmt.execute();
//			preparedStmt.close();
//			db.close();
			
			

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre suprimmer");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre suprimmer");
		}

		return new Reponse("ok", "votre produit est supprime avec succes");

	}

	public Reponse MyPubs(int id) {

		List<Product> res = new ArrayList<Product>();
		Product tmp;

		try {
			db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery(
					"SELECT * FROM Product WHERE  Product.UserId = " + id + " ORDER BY ProductDate DESC ");

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

				res.add(tmp);

			}
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "Erreur sur le serveur");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "Erreur sur le serveur");
		}
		return new Reponse("ok", res);
	}

	public Reponse allProducts() {


		List<Product> res = new ArrayList<Product>();
		Product tmp;

		try {
			db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Product");

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

				res.add(tmp);

			}
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			return new Reponse("ko", "Erreur sur le serveur");
		} catch (SQLException e) {
			return new Reponse("ko", "Erreur sur le serveur");
		}
		return new Reponse("ok", res);
	}

}
