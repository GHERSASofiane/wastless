package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import configuration.Connexion;
import status.Reponse;

public class ReservationDAO {


	private Connection db;
	
	
	public Reponse reserver(int productId, int userId)
	{
		try {
			db = Connexion.getConnection();
			String res = "update users set userName=? where userId=?;;";
			String res1 = "insert into booking values(?,?,?);";
			
			PreparedStatement pst = db.prepareStatement(res);
			PreparedStatement pst1 = db.prepareStatement(res1);
			
			pst.setInt(1, userId);
			pst.setInt(2, productId);
			
			
			pst1.setInt(1, userId);
			pst1.setInt(2, productId);
			pst1.setString(3, "date");
			
			pst.executeUpdate();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre reserver");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "votre produit n'a pas pu etre reserver");
		}
		
		return new Reponse("ok", "votre produit est reservé avec succes");
		
	}
	

}
