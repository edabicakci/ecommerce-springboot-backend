package com.godoro.spring.layer.business.service;

public interface CartProductService {
	
	void add(long cartId, long productId);
	void remove (long cartProductId, long productId);
	

}
