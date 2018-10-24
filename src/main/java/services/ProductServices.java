package services;
import java.util.Calendar;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProductDAO;
import models.Product;
import status.Reponse;

public class ProductServices {

	ProductDAO pr = new ProductDAO();
	

	public JsonObject MyPubs(int id)
	{

		if( !IsPresent(id) ) { return JSonConverter.objectToJson( new Reponse("ko", "Pas d'identifiant pour la recherch ") ); }
		
		return JSonConverter.objectToJson(pr.MyPubs(id));
	}
	
//* ********* function fin
	public JsonObject addProduct(Product product)
	{		  

		if( !IsPresent(product.getProductName()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductName est obligatoire") ); }
		if( !IsPresent(product.getProductDescription()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductDescription  est obligatoire") ); } 
		if( !IsPresent(product.getProductPrice()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductPrice  est obligatoire") ); } 
		if( !IsPresent(product.getUserId()) ) { return JSonConverter.objectToJson( new Reponse("ko", "UserId  est obligatoire") ); }  
		// TODO image
		
    	product.setProductDate(getDate());
    	product.setProductStatus(0);
    	
		return JSonConverter.objectToJson(pr.addProduct(product));
	}
	
// ****** fonction utiles
	
	private boolean IsPresent(String arg) {
		
		if(arg == null || arg.length() == 0) {
			return false;
		}else {
			return true;
		}
		
	}
	private boolean IsPresent(Integer arg) {
		
		if(arg == null ) {
			return false;
		}else {
			return true;
		}
		
	}
	
	
	public String getDate() {
		String Mydate = "";
		Calendar calendar = Calendar.getInstance();
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.YEAR)));
		Mydate = Mydate.concat("-");
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.MONTH)+1));
		Mydate = Mydate.concat("-");
		Mydate = Mydate.concat(Integer.toString(calendar.get(calendar.DAY_OF_MONTH)));
		
		return Mydate;
	}
	
}
