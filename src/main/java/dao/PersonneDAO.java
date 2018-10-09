package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import configuration.Connexion;
import models.Personne;



public class PersonneDAO {

	
	public Personne logIn(String user, String password)
	{
		Connection db;
		Personne personne = new Personne();
		
		try {
			db = Connexion.getConnection();
			Statement stmt = db.createStatement();
			String res = "select * from users where name =? and password=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
		//	while(rs.next())
		//	{
				personne.setName(rs.getString(1));
				personne.setPassword(rs.getString(2));
		//	}
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return personne;
	}
}
