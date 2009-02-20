package lighty.repository;

import java.util.List;

import lighty.domain.Product;

public interface ProductDao {
	
	public List<Product> getProductList();
	
	public void saveProduct(Product prod);
}
