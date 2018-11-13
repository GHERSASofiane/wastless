package apiService.backend;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configuration.Connexion;




public class getProductName {

	
	
	
	public static List<String> productNames()
	{
	List<String> res = new ArrayList<String>();

	try {
		Connection db  = Connexion.getConnection();

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
	
	
	

	
	
	public static void insert(List<ProductPrices> products)
	{
		StringBuilder sb = new StringBuilder();
		
		for(ProductPrices pPrices : products)
		{
			
			
			for(ProductStore offer : pPrices.getOffers())
			{
				System.out.println(" ---------" +  offer.getShop_name() + ", " + offer.getPrice());
				sb.append("('" + pPrices.getName() + "', " );
				sb.append("'" + offer.getShop_name() + "', " );
				sb.append("'" + offer.getPrice() + "', " );
				sb.append("'" + offer.getUrl() + "')" );
				
				sb.append(", " );
				
			}
			
		}
		
		if(sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		
		String values = sb.toString();
		System.out.println(values);
		
		try {
			Connection db = Connexion.getConnection();
			String res = " INSERT INTO productPrices VALUES" + values + ";";
					
			
			Statement statement = db.createStatement();
			statement.executeUpdate(res);
			
			statement.close();

			db.close();

		} catch (URISyntaxException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	
}
