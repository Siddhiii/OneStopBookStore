package com.ecommerce.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.CatIDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.ProductInfo;
import com.google.gson.Gson;
@Repository
public class CatDaoImp implements CatIDao
{

	@Autowired
	   SessionFactory sf;
		public void addcategory(Category cat) {
		  
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
			sess.save(cat);
			tran.commit();
			sess.flush();
			sess.close();
		}
		
		public String retrievecategory()
		{
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
			List catlist = sess.createQuery("from Category").list();
			Gson gson=new Gson();
			String jsonNames =gson.toJson(catlist);
			tran.commit();
			sess.close();
			return jsonNames;
			
		}
		
		public void deletecat(int id)

		 {
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
	        Category catdel  = (Category) sess.get(Category.class, id);
	    	sess.delete(catdel);
			tran.commit();
			sess.close();
			
		 }

		public Category catfetchProductbyid(int id)
		{
		   
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
			Category catlist=(Category) sess.get(Category.class,id);
			tran.commit();
			sess.close();
			return catlist;
		}

		public void updatecategory(Category catobj) 
		{
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
			sess.update(catobj);
			tran.commit();
			sess.close();
			
		}

		public void setcategorystatus(int id, String status)
		{
			Session sess = sf.openSession();
			Transaction tran = sess.beginTransaction();
			Category catlist=(Category) sess.get(Category.class,id);
			catlist.setCategorystatus(status);
			tran.commit();
			sess.close();
		}


}
