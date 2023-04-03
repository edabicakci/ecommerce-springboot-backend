package com.godoro.spring.layer.presentation.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.service.CartProductService;

@RestController
@RequestMapping("/cart")
public class CartProductController {
	
	CartProductService cartProductService;
	
	public CartProductController(CartProductService cartProductService) {
		this.cartProductService = cartProductService;	
		
	}
	
	@PostMapping("/add/{cartId}/{productId}")
	public void addCartProductDto(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		cartProductService.add(cartId, productId);
			
	}
	
	@DeleteMapping("/remove/{cartId}/{productId}")
	public void deleteCartProductDto(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId) {
		
		cartProductService.remove(cartId, productId);
			
	}
	
	
	
	
	
	

}
