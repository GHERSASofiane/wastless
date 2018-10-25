package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import configuration.Connexion;

import models.Product;
import status.Reponse;

public class UserReservationDAO {

	public Reponse getUserReservation(int userId) {
		
		Connection db;
		ArrayList<Product> products = new ArrayList<Product>();
		System.out.println("user id --------------->" + userId);
		try {
			db = Connexion.getConnection();
			
			//TODO a modifier avec la bonne requete
			String res = "select p.productId, p.productName, p.productDescription, p.productPrice, p.productPicture, p.productDate from booking as b, product as p  where b.userId=? and b.productId=p.productId;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setInt(1, userId);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				Product prod = new Product();
				prod.setProductId(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductDescription(rs.getString(3));
				prod.setProductPrice(rs.getString(4));
				prod.setProductPicture(rs.getString(5));
				prod.setProductDate(rs.getString(6));
				
				
				products.add(prod);
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}
		
		return new Reponse("ok", products);
	}

}
