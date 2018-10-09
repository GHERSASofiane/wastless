package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import configuration.Connexion;
import models.Personne;
import status.Reponse;

public class InscriptionDAO {

	
	public Reponse incription(Personne pers)
	{
		Connection db;

		try {
			db = Connexion.getConnection();
			
			String res = "select count(*) from users where usermail=? and userpassword=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, pers.getUsermail());
			pst.setString(2, pers.getUserpassword());
			
			ResultSet rs = pst.executeQuery();
			if(rs.getInt(1) > 0)
				return new Reponse("ko", "user exist, please change your user mail or your password");
			
			
			
			res = "insert into users values (?,?,?,?,?);";
			pst = db.prepareStatement(res);
			pst.setString(1, pers.getUsermail());
			pst.setString(2, pers.getUsername());
			pst.setString(3, pers.getUserpassword());
			pst.setString(4, pers.getUserphone());
			pst.setString(5, pers.getUseradresse());
			
			pst.executeQuery();
		} catch (URISyntaxException e) {
			return new Reponse("ko", "there was an error, please try again !!!");
		} catch (SQLException e) {
			return new Reponse("ko", "there was an error, please try again !!!");
		}
		
		return new Reponse("ok", "");
		
	}
	
	
}
