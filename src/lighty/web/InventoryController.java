package lighty.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lighty.service.ProductManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class InventoryController implements Controller{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private ProductManager productManager;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String now = (new Date()).toString();
		logger.info("Return hello view with " + now);
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		ProductManager pm = this.productManager;
		myModel.put("products", this.productManager.getProducts());
		
		return new ModelAndView("hello", "model", myModel);
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
