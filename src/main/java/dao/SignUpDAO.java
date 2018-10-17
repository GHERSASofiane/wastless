package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.Connexion;
import models.Personne;
import status.Reponse;

public class SignUpDAO {

	
	private Connection db;
	
	public Reponse signUp(Personne pers)
	{
		try {
			
			db = Connexion.getConnection();
			
			String res = "select count(*) from users where userMail =? and userPassword=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, pers.getUserMail());
			pst.setString(2, pers.getUserPassword());
			ResultSet rs = pst.executeQuery();
			
			int count = 0;
			while(rs.next())
			{
				count = rs.getInt(1);
			}
			
			if(count != 0)
				return new Reponse("ko", "user exists");
			res = "insert into users(userMail,userName, userPassword,userPhone,userAdress, userprofilepicture) values(?,?,?,?,?,?);";
			
			pst = db.prepareStatement(res);
			pst.setString(1, pers.getUserMail());
			pst.setString(2, pers.getUserName());
			pst.setString(3, pers.getUserPassword());
			pst.setInt(4, Integer.parseInt(pers.getUserPhone()));
			pst.setString(5, pers.getUserAddress());
			pst.setString(6, pers.getUserPicture());
			
			pst.executeUpdate();
			
			res = "select * from users where userMail =? and userPassword=?;";
			pst = db.prepareStatement(res);
			pst.setString(1, pers.getUserMail());
			pst.setString(2, pers.getUserPassword());
			rs = pst.executeQuery();
			
			 Personne personne = new Personne();
			while(rs.next())
			{
				personne.setUserMail(rs.getString(2));
				personne.setUserName(rs.getString(3));
				personne.setUserPicture(rs.getString(7));
			}
			
			
			
			return new Reponse("ok", personne);
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}
	
		
	}
}
