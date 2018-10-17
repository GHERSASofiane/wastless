package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import configuration.Connexion;
import models.Personne;
import status.Reponse;



public class SignInDAO {

	
	public Reponse logIn(Personne per)
	{
		Connection db;
		Personne personne = new Personne();
		
		try {
			db = Connexion.getConnection();
			String res = "select * from users where userMail =? and userPassword=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, per.getUserMail());
			pst.setString(2, per.getUserPassword());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				personne.setUserId(rs.getInt(1));
				personne.setUserMail(rs.getString(2));
				personne.setUserName(rs.getString(3));
				personne.setUserPicture(rs.getString(7));
			}
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}
		
		return new Reponse("ok", personne);
	}
}
