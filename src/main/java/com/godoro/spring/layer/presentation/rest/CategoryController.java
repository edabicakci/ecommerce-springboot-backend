package com.godoro.spring.layer.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.dto.CategoryDto;
import com.godoro.spring.layer.business.service.CategoryService;


@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	CategoryService categoryService;
	
	public CategoryController (CategoryService categoryService){
		this.categoryService = categoryService;
	}
	
	
	@GetMapping("/list")
	public List<CategoryDto> getCategories() {
		
		return categoryService.list();
		
	}
	
	@PostMapping("/add")
	public void addCategory(@RequestBody CategoryDto categoryDto) {
		
		categoryService.add(categoryDto);
		
	}
	
	
	
	

}
