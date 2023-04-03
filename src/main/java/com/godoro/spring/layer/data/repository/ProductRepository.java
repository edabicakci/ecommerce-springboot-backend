package com.godoro.spring.layer.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.layer.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
	
	List<Product> findByCategory_categoryId(long categoryId);

}
