package com.ecommerce.dao;

import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserCredential;
import com.ecommerce.model.UserModel;

public interface UserCredIDao {



	void adduserc(UserCredential usercred);
	String retrieveusercred();
	void deleteusercred(int id);
	UserCredential fetchusercredbyid(int id);
	void updateusercred(UserCredential userobj);
	
}
