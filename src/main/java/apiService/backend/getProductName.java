package apiService.backend;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import apiService.PriceAPI;
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

	public static JsonObject productExist(String productName) {
		System.out.println("--------------------------> : " + productName);
		try {
			Connection db = Connexion.getConnection();

			String req = ("SELECT * FROM productPrices where productName=?");
			PreparedStatement pst = db.prepareStatement(req);
			pst.setString(1, productName);
			ResultSet res = pst.executeQuery();

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

			if (!pPrices.getOffers().isEmpty())
			{
				List<ProductPrices> result= new ArrayList<ProductPrices>();
				result.add(pPrices);
				return JSonConverter.objectToJson(new Reponse("ok", result));
			}
			else {
				return JSonConverter.objectToJson(new Reponse("ok", searchProduct(productName)));
			}

		} catch (Exception e) {
			e.printStackTrace();
			return JSonConverter.objectToJson(new Reponse("ko", "oops, erreur 500"));

		}

	}

	public static List<ProductPrices> searchProduct(String productName) {
		String req = "select productName from product where productName not in (select productName from productPrices);";
		final List<ProductPrices> productprices = productFromAPI(productName.replaceAll(" ", "%20"));

		new Thread(new Runnable() {

			public void run() {

				getProductName.insert(productprices);

			}
		}).start();

		return productprices;
	}

	public static List<ProductPrices> productFromAPI(String productNames) {

		JsonObject obj = (JsonObject) PriceAPI.searchProduct(productNames);
		JsonArray result = obj.getAsJsonArray("results");
		List<ProductPrices> productprices = new ArrayList<ProductPrices>();

		for (JsonElement ele : result) {

			ProductPrices ps = null;

			if (ele.getAsJsonObject().get("content") instanceof JsonObject) {
				JsonObject product = ele.getAsJsonObject().get("content").getAsJsonObject();
				ps = new ProductPrices();
				ps = (ProductPrices) JSonConverter.objectFromJson(product, ps);
			}

			if (ps != null && ele.getAsJsonObject().get("query") instanceof JsonObject) {
				JsonObject product = ele.getAsJsonObject().get("query").getAsJsonObject();
				ps.setName(product.get("value").getAsString());
				productprices.add(ps);
			}

		}

		return productprices;
	}

	public static void deleteProductsFromDB() {

		try {
			Connection db = Connexion.getConnection();
			Statement pst = db.createStatement();
			pst.executeQuery(" delete from productPrices;");
			pst.close();
			db.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
