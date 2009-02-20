package lighty.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import lighty.service.PriceIncrease;
import lighty.service.ProductManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

public class PriceIncreaseFormController extends SimpleFormController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	private ProductManager productManager;

	public ModelAndView onSubmit(Object command) throws ServletException {
		int increase = ((PriceIncrease) command).getPercentage();
		logger.info("Increase prices by " + increase + "%.");
		
		productManager.increasePrice(increase);
		logger.info("returning from PriceIncreaseForm view to " + getSuccessView());
		
		return new ModelAndView(new RedirectView(getSuccessView()));
	}
	
	public Object formBackingObject(HttpServletRequest request) throws ServletException {
		PriceIncrease priceIncrease = new PriceIncrease();
		priceIncrease.setPercentage(20);
		return priceIncrease;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	public ProductManager getProductManager() {
		return productManager;
	}
}
