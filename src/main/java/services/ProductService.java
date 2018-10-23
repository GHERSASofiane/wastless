package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProductDAO;
import models.Product;
import status.Reponse;

import javax.servlet.http.HttpServletRequest;



public class ProductService {

	ProductDAO pr = new ProductDAO();
	
	public JsonObject searchProduct(String nameArticle, int page)
	{
		return JSonConverter.objectToJson(pr.searchProduct(nameArticle, page));
	}
	
	
	public JsonObject addProduct(Product product)
	{		// pr.addProduct(product)
		return JSonConverter.objectToJson(new Reponse("ok", product));
	}
	
	public JsonObject deleteProduct(String productName, double productPrice, int userId)
	{
		return JSonConverter.objectToJson(pr.deleteProduct(productName, productPrice, userId));
	}
	
	public JsonObject getProductDetails(String productId)
	{
		return JSonConverter.objectToJson(pr.getProductDetails(productId));
	}
	

	public JsonObject validateProduct(String productId)
	{
		return JSonConverter.objectToJson(pr.validateProduct(productId));
	}
	
	public JsonObject bookProduct(String productId, String userId) {
		return JSonConverter.objectToJson(new Reponse("ok","TODO"));
	}
	
}
