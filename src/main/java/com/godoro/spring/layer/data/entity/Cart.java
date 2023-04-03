package com.godoro.spring.layer.data.entity;

import com.godoro.spring.enums.CartStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cartId;
	private String customerName;
	private int cartNumber;
	private CartStatus cardStatus;
	
	
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCartNumber() {
		return cartNumber;
	}
	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
	}
	public CartStatus getCardStatus() {
		return cardStatus;
	}
	public void setCardStatus(CartStatus cardStatus) {
		this.cardStatus = cardStatus;
	}
	
	
	
	

}
