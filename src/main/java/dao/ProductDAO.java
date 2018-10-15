package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import configuration.Connexion;
import models.Personne;
import models.Product;
import status.Reponse;

public class ProductDAO {

	
	private Connection db;
	
	
	public Reponse searchProduct()
	{
		return new Reponse("ok", "bla bla");
	}
	
	
	public Reponse addProduct(int productId, String productName, String productDescription, double productPrice, int productStatus, int userId, String productDate)
	{
		
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
	
	public Reponse deleteProduct(String productName, double productPrice, int userId)
	{
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
	
	public Reponse getProductDetails(int productId)
	{
		Product product = new Product();
		try {
			db = Connexion.getConnection();
			String res = "select * from product where productId=?";
			
			
			PreparedStatement pst = db.prepareStatement(res);
			pst.setInt(1, productId);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				product.setProductName(rs.getString(2));
				product.setProductDescription(rs.getString(3));
				product.setProductPrice(rs.getDouble(4));
				product.setProductStatus(rs.getInt(6));
				product.setProductDate(rs.getString(8));
			}
			
			pst.close();
			rs.close();
			db.close();
			
		} catch (URISyntaxException e) {
			return new Reponse("ko", "y avait eu une erreur");
		} catch (SQLException e) {
			return new Reponse("ko", "y avait eu une erreur");
		}
		
		
		return new Reponse("ok", product);

	}

	public Reponse validateProduct (String productId) {
		
		try {
			db = Connexion.getConnection();
			Statement pst = db.createStatement();
		
			pst.executeQuery(" UPDATE product Set productStatus = 2 WHERE productId = " +productId+ ";");
			
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
