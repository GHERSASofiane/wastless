package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import configuration.Connexion;
import models.Personne;

public class InscriptionDAO {

	
	public boolean incription(Personne pers)
	{
		Connection db;

		try {
			db = Connexion.getConnection();
			String res = "insert into users values (?,?,?,?,?);";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, pers.getUsermail());
			pst.setString(2, pers.getUsername());
			pst.setString(3, pers.getUserpassword());
			pst.setString(4, pers.getUserphone());
			pst.setString(5, pers.getUseradresse());
			
			pst.executeQuery();
		} catch (URISyntaxException e) {
			return false;
		} catch (SQLException e) {
			return false;
		}
		
		return true;
		
	}
	
	
}
