package com.mc437.produshow.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
//	@RequestMapping(name="teste", method=RequestMethod.GET)
//	public void testt () {
//		System.out.println("BLABLA");
//		return;
//	}
	
	@RequestMapping(name="/productId", method=RequestMethod.GET)
	public Product getProductById (@PathVariable("productId") Long productId) {
//		Long productId = 1L;
		System.out.println("product id " + productId);
		return productService.getProductById(productId);
	}
}
