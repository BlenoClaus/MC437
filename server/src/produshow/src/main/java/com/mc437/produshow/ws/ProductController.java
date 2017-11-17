package com.mc437.produshow.ws;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Product;
import com.mc437.produshow.model.SortOrderType;
import com.mc437.produshow.model.validator.ProductValidator;
import com.mc437.produshow.service.ProductService;
import com.mc437.produshow.ws.body.Amount;

/**
 * Created by gustavo on 21/09/17.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService; 
	
    @RequestMapping(value = {"", "/"}, method = GET)
    public Page<Product> findAll(Pageable p) {
        return productService.findAll(p);
    }
    
    @RequestMapping(value = {"search"}, method = GET)
    public Page<Product> search(@RequestParam(name = "query", required=false) String query,
    			@RequestParam(name = "category", required=false) String category,
    			@RequestParam(name = "sortOrder", required=false) String sortOrder,
    			Pageable p) {
    	
    	SortOrderType sortOrderType = null;
    	if (sortOrder != null && sortOrder.equals("high")) {
    		sortOrderType = SortOrderType.HIGHEST_PRICE;
    	} else	if (sortOrder != null && sortOrder.equals("low")) {
    		sortOrderType = SortOrderType.LOWER_PRICE;
    	}
    	return productService.searchProducts(query, category, sortOrderType, p);
    }

    @RequestMapping(value = "/{productId}", method = GET)
    public Product findById(@PathVariable("productId") long productId) throws GeneralException {
        return productService.findById(productId);
    }
    
    @RequestMapping(value = "/{productId}/remove", method = POST)
    public Amount remove(@PathVariable("productId") long productId, @RequestBody Amount amount) throws GeneralException {
        if (amount == null) {
        	throw new GeneralException("AMOUNT_VALUE_MUST_NOT_BE_NULL");
        } else {
        	Amount resultAmount = new Amount();
        	resultAmount.setAmount(productService.removeSome(productId, amount.getAmount()));
        	return resultAmount;
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = POST)
    public Product createProduct(@Valid @RequestBody Product product) throws GeneralException {
        return productService.create(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{productId}", method = PUT)
    public Product updateProduct(@PathVariable("productId") long productId, @RequestBody Product product) throws GeneralException {
        return productService.update(product, productId);
    }

    
    @InitBinder("product")
	void initValidator(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}
}
