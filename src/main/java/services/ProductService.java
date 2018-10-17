package services;

import com.google.gson.JsonObject;

import converters.JSonConverter;
import dao.ProductDAO;



public class ProductService {

	ProductDAO pr = new ProductDAO();
	
	public JsonObject searchProduct(String nameArticle, int page)
	{
		return JSonConverter.objectToJson(pr.searchProduct(nameArticle, page));
	}
	
	
	public JsonObject addProduct(int productId, String productName, String productDescription, double productPrice, int productStatus, int userId, String productDate)
	{		
		return JSonConverter.objectToJson(addProduct(productId, productName, productDescription, productPrice, productStatus, userId, productDate));
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
	
}
