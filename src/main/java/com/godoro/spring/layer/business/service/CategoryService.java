package com.godoro.spring.layer.business.service;

import java.util.List;

import com.godoro.spring.layer.business.dto.CategoryDto;

public interface CategoryService  {
	
	
	void add(CategoryDto categoryDto);
	CategoryDto find(long categoryId);
	List<CategoryDto> list();
	

}
