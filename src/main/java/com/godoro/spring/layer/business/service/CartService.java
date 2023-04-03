package com.godoro.spring.layer.business.service;

import com.godoro.spring.layer.business.dto.CartDto;

public interface CartService {
	
	void checkout(CartDto cartDto);
	CartDto find(long cartId);

}
