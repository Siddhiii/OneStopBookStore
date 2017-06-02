package com.ecommerce.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.UserIDao;
import com.ecommerce.model.UserModel;
import com.ecommerce.service.UserIService;

@Service
public class UserIServiceImp implements UserIService {
	@Autowired
	UserIDao useridao;

	public void adduser(UserModel usermodel) {
		useridao.adduser(usermodel);

	}

}
