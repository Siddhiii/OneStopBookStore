package com.ecommerce.dao;

import com.ecommerce.model.UserModel;

//add retrieve fetch
public interface UserIDao {

	void adduser(UserModel usermodel);
	String retrieveuser();
}
