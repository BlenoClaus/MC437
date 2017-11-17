package com.mc437.produshow.ws;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.model.product.ProductPage;
import com.mc437.produshow.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="{productId}", method=RequestMethod.GET)
	public Product getProductById (@PathVariable("productId") Long productId) throws IOException, GeneralException {
		return productService.getProductById(productId);
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public ProductPage searchProducts (
			@RequestParam(name="query", required=true) String query, 
			@RequestParam(name="category", required=false)String category,
			@RequestParam(name="size", required=false)Long size, 
			@RequestParam(name="page", required=false)Long page) throws GeneralException, IOException {
		return productService.searchProducts(query, category, size, page);
	}
}
