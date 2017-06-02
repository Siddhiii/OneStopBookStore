package com.ecommerce.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.UserIDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserModel;
import com.google.gson.Gson;
@Repository
public class UserIDaoImp implements UserIDao {
	@Autowired
	SessionFactory sf;
	public void adduser(UserModel usermodel) {
	  
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.save(usermodel);
		tran.commit();
		sess.flush();
		sess.close();
	}
	public String retrieveuser() {
		
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		List prodlist = sess.createQuery("from UserModel").list();
		Gson gson=new Gson();
		String jsonNames =gson.toJson(prodlist);
		tran.commit();
		sess.close();
		return jsonNames;
		
		
	}
	
	public UserModel fetchProductbyid(int id)
	{
	   
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		UserModel userm=(UserModel) sess.get(UserModel.class,id);
		tran.commit();
		sess.close();
		return userm;
	}

	

	
}
