package com.godoro.spring.layer.presentation.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godoro.spring.layer.business.dto.CartDto;
import com.godoro.spring.layer.business.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	CartService cartService;
	
	public CartController(CartService cartService) {
		this.cartService = cartService;
		
	}
	
	
	@GetMapping("/get/{cartId}")
	public CartDto getCart(@PathVariable("cartId") long cartId) {	
		return cartService.find(cartId);
			
	}
	
	@PutMapping("/checkout")
	public void checkoutCart(@RequestBody CartDto cartDto) {	
		cartService.checkout(cartDto);
			
	}
	
	

}
