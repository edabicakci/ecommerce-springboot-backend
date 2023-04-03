package com.godoro.spring.layer.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.godoro.spring.layer.business.dto.CartProductDto;
import com.godoro.spring.layer.data.entity.Cart;
import com.godoro.spring.layer.data.entity.CartProduct;
import com.godoro.spring.layer.data.entity.Product;
import com.godoro.spring.layer.data.repository.CartProductRepository;
import com.godoro.spring.layer.data.repository.CartRepository;
import com.godoro.spring.layer.data.repository.ProductRepository;

@Service
public class CartProductServiceImp implements CartProductService {

	CartProductRepository cartProductRepository;
	CartRepository cartRepository;
	ProductRepository productRepository;

	public CartProductServiceImp(CartProductRepository cartProductRepository, CartRepository cartRepository,
			ProductRepository productRepository) {
		this.cartProductRepository = cartProductRepository;
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;

	}

	@Override
	public void add(long cartId, long productId) {

		CartProduct cartProduct = new CartProduct();

		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		Optional<Product> optionalProduct = productRepository.findById(productId);

		if (optionalCart.isPresent() && optionalProduct.isPresent()) {

			cartProduct.setCart(optionalCart.get());
			cartProduct.setProductId(productId);

			cartProductRepository.save(cartProduct);

		}

	}

	@Override
	public void remove(long cartId, long productId) {
		
		CartProduct cartProduct = cartProductRepository.findByCartIdAndProductId(cartId, productId);
		
		if (cartProduct != null) {

			cartProductRepository.deleteById(cartProduct.getCartProductId());

		}
		

	}

	private CartProduct toEntity(CartProductDto cartProductDto) {

		CartProduct cartProduct = new CartProduct();

		cartProduct.setCartProductId(cartProductDto.getCartProductId());
		cartProduct.setCart(cartProductDto.getCart());
		cartProduct.setProductId(cartProductDto.getProductId());
		cartProduct.setSalesQuantity(cartProductDto.getSalesQuantity());

		return cartProduct;

	}

}
