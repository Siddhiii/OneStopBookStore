package com.ecommerce.dao;

import com.ecommerce.model.CartModel;

public interface CartIDao {

	void addCart(CartModel cartmodel);
    String retrieveCarts(String username);
    void deleteCart(String id);
    void updateCart(int id, int quantity);
    long getTotalPriceOfCart(String username);
    long getTotalQuantityOfCart(String username);
}
