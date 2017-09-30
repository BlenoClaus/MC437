package com.mc437.produshow.ws;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.Product;
import com.mc437.produshow.model.validator.LotValidator;
import com.mc437.produshow.model.validator.ProductValidator;
import com.mc437.produshow.service.ProductService;

/**
 * Created by gustavo on 21/09/17.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService; 
	
    @RequestMapping(value = {"", "/"}, method = GET)
    @ResponseBody
    public Page<Product> findAll(Pageable p) {
    	System.out.println("context " + SecurityContextHolder.getContext().getAuthentication().getDetails());
        return productService.findAll(p);
    }

    @RequestMapping(value = "/{productId}", method = GET)
    @ResponseBody
    public Product findById(@PathVariable("productId") long productId) throws GeneralException {
        return productService.findById(productId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "", method = POST)
    @ResponseBody
    public Product createProduct(@Valid @RequestBody Product product) throws GeneralException {
        return productService.create(product);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/{productId}", method = PUT)
    @ResponseBody
    public Product updateProduct(@PathVariable("productId") long productId, @RequestBody Product product) throws GeneralException {
        return productService.update(product, productId);
    }

    
    @InitBinder("product")
	void initValidator(WebDataBinder binder) {
		binder.setValidator(new ProductValidator());
	}
}
