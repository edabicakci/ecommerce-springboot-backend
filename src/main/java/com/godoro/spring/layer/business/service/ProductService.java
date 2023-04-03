package com.godoro.spring.layer.business.service;

import java.util.List;

import com.godoro.spring.layer.business.dto.ProductDto;

public interface ProductService {
	
	ProductDto find (long productId);
	List<ProductDto> findByCategory_categoryId(long categoryId);
	
}
