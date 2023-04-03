package com.godoro.spring.layer.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.layer.data.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
