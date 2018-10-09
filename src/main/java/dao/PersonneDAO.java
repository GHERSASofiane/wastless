package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import configuration.Connexion;

import status.Reponse;



public class PersonneDAO {

	
	public Reponse logIn(String user, String password)
	{
		Connection db;
		
		
		try {
			db = Connexion.getConnection();
			
			String res = "select count(*) from users where username =? and userpassword=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, user);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			int result = rs.getInt(1);
			
			if(result == 1)
				return new Reponse("ok", "");
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Reponse("ko", "user don't exist,please check your mail or password or create new account");
	}
}
