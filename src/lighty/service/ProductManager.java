package lighty.service;

import java.io.Serializable;
import java.util.List;

import lighty.domain.Product;

public interface ProductManager extends Serializable {

		public void increasePrice(int percentage);
		public List<Product> getProducts();
}
