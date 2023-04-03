package com.godoro.spring.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.dto.ProductDto;
import com.godoro.spring.layer.business.service.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {

	ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;

	}
	
	
	@GetMapping("/product/{id}")
	public ProductDto getProduct(@PathVariable("id") long productId) {
		
		return productService.find(productId);
		
	}
	
	@GetMapping("/products/{categoryId}")
	public List<ProductDto> getProductsByCategoryId(@PathVariable("categoryId") long categoryId) {
		return productService.findByCategory_categoryId(categoryId);
		
		
	}

}
