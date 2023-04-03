package com.godoro.spring.layer.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.godoro.spring.layer.data.entity.Cart;

public interface CartRepository extends CrudRepository<Cart, Long>{

}
