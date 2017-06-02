package com.ecommerce.service;

import com.ecommerce.model.CartModel;

public interface CartIService {
	void addCart(CartModel cartmodel);
    String retrieveCarts(String username);
    void deleteCart(String id);
    void updateCart(int id, int quantity);
    long getTotalPriceOfCart(String username);
    long getTotalQuantityOfCart(String username);
}

