/**
 * 
 */
package com.web.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.web.product.model.Product;

/**
 * @author dsure
 *
 */
@Component
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 
	 * @return
	 */
	public Product getProductByID(Long id) {
		ResponseEntity<Product> product = (ResponseEntity<Product>) restTemplate.getForEntity("http://localhost:8080/{id}", Product.class);
		productStatusUpdate();
		return product.getBody();
	}
	
	private String productStatusUpdate() {
		return "Sucess";
	}
	
	public List<Product> getAllProduct() {
		return new ArrayList<Product>();
	}
}
