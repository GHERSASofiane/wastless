package apiService.backend;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;

import configuration.Connexion;
import converters.JSonConverter;
import status.Reponse;

public class getProductName {

	public static List<String> productNames() {
		List<String> res = new ArrayList<String>();

		try {
			Connection db = Connexion.getConnection();

			Statement stmt = db.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT productName FROM Product");

			while (rs.next()) {
				res.add(rs.getString("ProductName"));
			}
			stmt.close();
			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return res;
	}

	public static void insert(List<ProductPrices> products) {

		try {
			Connection db = Connexion.getConnection();

			for (ProductPrices pPrices : products) {

				for (ProductStore offer : pPrices.getOffers()) {

					String res = "insert into productPrices values (?,?,?,?);";
					PreparedStatement pst = db.prepareStatement(res);
					pst.setString(1, pPrices.getName());
					pst.setString(2, offer.getShop_name());

					pst.setDouble(3, offer.getPrice());
					pst.setString(4, offer.getUrl());

					pst.executeUpdate();

				}

			}

			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
	
	
	public static JsonObject productExist(String productName)
	{
		System.out.println("--------------------------> : " + productName);
		try {
			Connection db = Connexion.getConnection();

			String req = ("SELECT * FROM productPrices where productName=?");
			PreparedStatement pst = db.prepareStatement(req);
			pst.setString(1, productName.replaceAll("%20", " "));
			ResultSet res =  pst.executeQuery();
			
			ProductPrices pPrices = new ProductPrices();
			pPrices.setName(productName);
			
			
			while (res.next()) {
				ProductStore ps = new ProductStore();
				ps.setShop_name(res.getString("storename"));
				ps.setPrice(res.getDouble("price"));
				ps.setUrl(res.getString("url"));
				pPrices.getOffers().add(ps);
			}
			
			pst.close();
			db.close();
			
			if(!pPrices.getOffers().isEmpty())
				return JSonConverter.objectToJson(new Reponse("ok", pPrices));
			
			

		} catch (Exception e) {
			e.printStackTrace();
			return JSonConverter.objectToJson(new Reponse("ko", "oops, erreur 500"));
			

		} 
		
		return JSonConverter.objectToJson(new Reponse("ko", "aucun produit trouvé"));
	}

}
