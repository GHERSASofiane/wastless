package services;
import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProductDAO;
import models.Product;
import status.Reponse;

public class ProductServices {

	ProductDAO pr = new ProductDAO();
	
	public JsonObject addProduct(Product product)
	{		  

		if( !IsPresent(product.getProductName()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductName est obligatoire") ); }
		if( !IsPresent(product.getProductDescription()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductDescription  est obligatoire") ); } 
		if( !IsPresent(product.getProductPrice()) ) { return JSonConverter.objectToJson( new Reponse("ko", "ProductPrice  est obligatoire") ); } 
		if( !IsPresent(product.getUserId()) ) { return JSonConverter.objectToJson( new Reponse("ko", "UserId  est obligatoire") ); }  
		// TODO image
		
		return JSonConverter.objectToJson(pr.addProduct(product));
	}
	

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
	
}
