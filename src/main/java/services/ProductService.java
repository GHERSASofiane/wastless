package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProductDAO;
import models.Product;
import status.Reponse;
  
public class ProductService {

	ProductDAO pr = new ProductDAO(); 
   
// **************************
	
	public JsonObject validateProduct(String productId)
	{
		return JSonConverter.objectToJson(pr.validateProduct(productId));
	}
	
	public JsonObject bookProduct(String productId, String userId) {
		return JSonConverter.objectToJson(new Reponse("ok","TODO"));
	}
	
	public JsonObject allProducts()
	{
		ProductDAO pdao = new ProductDAO();
		return JSonConverter.objectToJson(pdao.allProducts());
	}
}
