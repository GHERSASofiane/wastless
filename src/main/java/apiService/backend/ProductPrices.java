package apiService.backend;

import java.util.ArrayList;
import java.util.List;

public class ProductPrices {

	private String name;
	private List<ProductStore> offers = new ArrayList<ProductStore>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ProductStore> getOffers() {
		return offers;
	}
	public void setOffers(List<ProductStore> offers) {
		this.offers = offers;
	}
	
	
	
}
