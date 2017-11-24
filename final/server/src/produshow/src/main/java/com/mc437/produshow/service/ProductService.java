package com.mc437.produshow.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import com.mc437.produshow.GeneralException;
import com.mc437.produshow.model.product.Product;
import com.mc437.produshow.model.product.ProductPage;
import com.mc437.produshow.retro.ProductModule;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Service
public class ProductService {
	
	@Value("${module.product.baseUrl}")
	private String baseUrl;
	
	@Value("${module.product.token}")
	private String token;
	
	@Autowired
	private ProductModule productModule;
	
	public Product getProductById(Long productId) throws IOException, GeneralException {
		Response<Product> response = this.productModule.getProduct(productId, token).execute();
		Product product = response.body();
		if (product == null) {
			throw new GeneralException("PRODUCT_NOT_FOUND");
		}		
		return product;
	}
	
	public ProductPage searchProducts (String query, String category, Long size, Long page) throws GeneralException, IOException {
		Response<ProductPage> response = this.productModule.searchProducts(query, category, size, page, token).execute();
		ProductPage products = response.body();
		if (products == null) {
			throw new GeneralException("PRODUCTS_NOT_FOUND");
		}
		
		return products;
	}
	
	@Bean
	private ProductModule productModule () {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(this.baseUrl)
				.addConverterFactory(JacksonConverterFactory.create()).build();
		return retrofit.create(ProductModule.class);
	}
	
}
