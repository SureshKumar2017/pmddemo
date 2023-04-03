/**
 * 
 */
package com.web.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.web.product.model.Product;
import com.web.product.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author dsure
 *
 */
@RestController
public class ProductController {
	
	@Autowired
	public ProductService productService;
	
	@GetMapping("/product/{id}")
	public Mono<Product> getProductByID(@PathVariable String id) {
		System.out.println(" Product List Fetch ");
		Long productId = validateId(id);
		return Mono.just(productService.getProductByID(productId));
	}
	@GetMapping("/product")
	public Flux<List<Product>> loadProductList() {
		System.out.println(" Product List Fetch ");
		return Flux.just(productService.getAllProduct());
	}
	
	private Long validateId(String id) {
		if(id!=null && !"".equalsIgnoreCase(id)) {
			return Long.valueOf(id);
		}
		return null;
	}
	
	private String validateProductStatus(String id) {
		System.out.println("=");
		return "";
	}
	
}
