package com.ecommerce.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.UserCredIDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserCredential;
import com.ecommerce.model.UserModel;
import com.google.gson.Gson;
@Repository
public class UserCredDaoImp implements UserCredIDao {
	@Autowired
	SessionFactory sf;
	public void adduserc(UserCredential usercred) {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.save(usercred);
		tran.commit();
		sess.flush();
		sess.close();

	}
	public String retrieveusercred() {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		List userlist = sess.createQuery("from UserCredential").list();
		Gson gson=new Gson();
		String jsonNames =gson.toJson(userlist);
		tran.commit();
		sess.close();
		return jsonNames;
	}
	public void deleteusercred(int id) {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
        UserCredential usercredel  = (UserCredential) sess.get(UserCredential.class, id);//askkkk
    	sess.delete(usercredel);
		tran.commit();
		sess.close();
		
		
	}
	public UserCredential fetchusercredbyid(int id) {
		
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		UserCredential usercred=(UserCredential) sess.get(UserCredential.class,id);
		tran.commit();
		sess.close();
		return usercred;
	}
	
	public void updateusercred(UserCredential userobj) {
		// TODO Auto-generated method stub
		
	}
	
}
