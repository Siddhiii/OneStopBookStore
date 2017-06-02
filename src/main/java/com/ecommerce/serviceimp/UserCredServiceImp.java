package com.ecommerce.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IDao;
import com.ecommerce.dao.UserCredIDao;
import com.ecommerce.model.UserCredential;
import com.ecommerce.model.UserModel;
import com.ecommerce.service.UserCredIService;
@Service
public class UserCredServiceImp implements UserCredIService {
	@Autowired
	UserCredIDao usercredidao;
	public void adduserc(UserCredential usercred) {
		usercredidao.adduserc(usercred);
		

	}
	public String retrieveusercred(){
		return 	usercredidao.retrieveusercred();
	
	}
	public void deleteusercred(int id) {
		usercredidao.deleteusercred(id);
		
	}
	public UserCredential fetchusercredbyid(int id) {
		
		return usercredidao.fetchusercredbyid(id);
	}
	public void updateusercred(UserCredential userobj) {
		usercredidao.updateusercred(userobj);
		
	}
	


}
