package lighty.repository;

import java.util.List;

import lighty.domain.Product;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class JdbcProductDaoTests extends AbstractTransactionalDataSourceSpringContextTests{
	private ProductDao productDao;
	
	@Override
	protected String[] getConfigLocations() {
		return new String[] {"classpath:test-context.xml"};
	}
	
	@Override
	protected void onSetUpInTransaction() throws Exception {
		super.deleteFromTables(new String[] {"products"});
		super.executeSqlScript("file:db/load_data.sql", true);
	}
	
	public void testGetProductList() {
		List<Product> products = productDao.getProductList();
		assertEquals("wrong number of products?", 3, products.size());
	}
	
	public void testSaveProduct() {
		List<Product> products = productDao.getProductList();
		
		for(Product p : products) {
			p.setPrice(200.12);
			productDao.saveProduct(p);
		}
		
		List<Product> updatedProducts = productDao.getProductList();
		
		for(Product p : updatedProducts) {
			assertEquals("wrong price of product?", 200.12, p.getPrice());
		}
	}
}
