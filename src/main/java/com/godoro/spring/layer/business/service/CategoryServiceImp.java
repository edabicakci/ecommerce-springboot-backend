package com.godoro.spring.layer.business.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.layer.business.dto.CategoryDto;
import com.godoro.spring.layer.data.entity.Category;
import com.godoro.spring.layer.data.repository.CategoryRepository;


@Service
public class CategoryServiceImp implements CategoryService {

	CategoryRepository categoryRepository;

	public CategoryServiceImp(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	@Override
	public void add(CategoryDto categoryDto) {
		

		categoryRepository.save(toEntity(categoryDto));
	}
	

	@Override
	public CategoryDto find(long categoryId) {
		Optional<Category> optional = categoryRepository.findById(categoryId);

		if (optional.isPresent()) {

			return toDto(optional.get());
		}

		return null;
	}

	@Override
	public List<CategoryDto> list() {

		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();

		for (Category category : categoryRepository.findAll()) {

			categoryDtoList.add(toDto(category));

		}
		return categoryDtoList;
	}

	private CategoryDto toDto(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(category.getCategoryId());
		categoryDto.setCategoryName(category.getCategoryName());
		categoryDto.setProductList(category.getProductList());
		return categoryDto;
	}

	private Category toEntity(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setCategoryName(categoryDto.getCategoryName());
		category.setProductList(categoryDto.getProductList());
		return category;
	}

}
