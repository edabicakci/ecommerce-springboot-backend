package com.godoro.spring.layer.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.enums.CartStatus;
import com.godoro.spring.layer.business.dto.CartDto;
import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.repository.CartRepository;

@Service
public class CartServiceImp implements CartService {

	CartRepository cartRepository;

	public CartServiceImp(CartRepository cartRepository) {

		this.cartRepository = cartRepository;
	}

	@Override
	public void checkout(CartDto cartDto) {
	
		Optional<Cart> optional = cartRepository.findById(cartDto.getCartId());
		if(optional.isPresent()) {
			
			Cart cart = optional.get();
			CartStatus cartStatus = cart.getCardStatus();
			
			if(cartStatus == CartStatus.NEW) {
				cart.setCardStatus(CartStatus.COMPLETED);
				cartRepository.save(cart);
			}
		}
		
	}

	
	// finds the cart and if doesn't exist, create one
	@Override
	public CartDto find(long cartId) {
		Optional<Cart> optional = cartRepository.findById(cartId);

		if (optional.isPresent()) {
			return toDto(optional.get());

		} else {

			CartDto cartDto = new CartDto();
			cartDto.setCustomerName("Eda Bıçakcı");
			cartDto.setCartNumber(0);
			cartDto.setCardStatus(CartStatus.NEW);

			cartRepository.save(toEntity(cartDto));
			return cartDto;
		}

	}

	private Cart toEntity(CartDto cartDto) {
		Cart cart = new Cart();

		cart.setCartId(cartDto.getCartId());
		cart.setCustomerName(cartDto.getCustomerName());
		cart.setCartNumber(cartDto.getCartNumber());
		cart.setCardStatus(cartDto.getCardStatus());

		return cart;
	}

	private CartDto toDto(Cart cart) {

		CartDto cartDto = new CartDto();

		cartDto.setCartId(cart.getCartId());
		cartDto.setCustomerName(cart.getCustomerName());
		cartDto.setCartNumber(cart.getCartNumber());
		cartDto.setCardStatus(cart.getCardStatus());

		return cartDto;

	}

}
