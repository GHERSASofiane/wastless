package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import configuration.Connexion;
import models.Personne;
import status.Reponse;

public class ProfileDAO {

	private Connection db;

	public Reponse logIn(Personne per) {

		Personne personne = new Personne();

		if (!userExist(per))
			return new Reponse("ko", "userDon't exist");

		try {

			db = Connexion.getConnection();

			String res = "select * from users where userMail =? and userPassword=?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setString(1, per.getUserMail());
			pst.setString(2, per.getUserPassword());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				personne.setUserId(rs.getInt(1));
				personne.setUserMail(rs.getString(2));
				personne.setUserName(rs.getString(3));
				personne.setUserPhone(rs.getString(5));
				personne.setUserAddress(rs.getString(6));
				personne.setUserPicture(rs.getString(7));
			}

			pst.close();
			rs.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}

		return new Reponse("ok", personne);
	}

	public Reponse signUp(Personne pers) {

		if (userExist(pers))
			return new Reponse("ko", "user exists");

		try {

			db = Connexion.getConnection();
			String res = "insert into users(userMail,userName, userPassword,userPhone,userAdress, userprofilepicture) values(?,?,?,?,?,?);";

			PreparedStatement pst = db.prepareStatement(res);
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
			ResultSet rs = pst.executeQuery();

			Personne personne = new Personne();
			while (rs.next()) {
				personne.setUserId(rs.getInt(1));
				personne.setUserMail(rs.getString(2));
				personne.setUserName(rs.getString(3));
				personne.setUserPhone(rs.getString(5));
				personne.setUserAddress(rs.getString(6));
				personne.setUserPicture(rs.getString(7));
			}

			db.close();
			return new Reponse("ok", personne);

		} catch (URISyntaxException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {
			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}
	}

	public Reponse editProfile(Personne p) {

		try {
			if (!userExist(p.getUserId())) {
				db.close();
				return new Reponse("ko", "user Don't exist");
			}

			db = Connexion.getConnection();

			String req = "UPDATE users SET (userMail, userName, userPassword, userPhone, userAdress, userprofilepicture) = (?,?,?,?,?,?)"
					+ "  WHERE userId = ?;";

			PreparedStatement pst = db.prepareStatement(req);
			pst.setString(1, p.getUserMail());
			pst.setString(2, p.getUserName());
			pst.setString(3, p.getUserPassword());
			pst.setInt(4, Integer.parseInt(p.getUserPhone()));
			pst.setString(5, p.getUserAddress());
			pst.setString(6, p.getUserPicture());
			pst.setInt(7, p.getUserId());

			pst.executeUpdate();

			pst.close();
			db.close();

		} catch (URISyntaxException e) {

			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		} catch (SQLException e) {

			e.printStackTrace();
			return new Reponse("ko", "error !!! try again please");
		}

		return new Reponse("ok", "you profile was updated");
	}

	private boolean userExist(int userId) {

		try {
			db = Connexion.getConnection();
			String res = "select count(*) from users where userId =?;";
			PreparedStatement pst = db.prepareStatement(res);
			pst.setInt(1, userId);

			ResultSet rs = pst.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);
			}

			if (count == 0) {
				db.close();
				return false;

			}

			db.close();
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}

		return true;
	}

	private boolean userExist(Personne per) {

		try {

			String req = "select count(*) from users where userMail =? and userPassword=?;";

			db = Connexion.getConnection();
			PreparedStatement pst = db.prepareStatement(req);
			pst.setString(1, per.getUserMail());
			pst.setString(2, per.getUserPassword());

			ResultSet rs = pst.executeQuery();
			int count = 0;
			while (rs.next()) {

				count = rs.getInt(1);

			}

			if (count == 0)
				return false;

			pst.close();
			rs.close();
			db.close();

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
