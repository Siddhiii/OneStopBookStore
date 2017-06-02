package com.ecommerce.daoimp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.CartIDao;
import com.ecommerce.model.CartModel;
import com.ecommerce.model.ProductInfo;
import com.google.gson.Gson;
@Repository
public class CartDaoImp implements CartIDao {
	@Autowired
	SessionFactory sf;
	public void addCart(CartModel cartmodel) {


		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.save(cartmodel);
		tran.commit();
		sess.flush();
		sess.close();
	}

	public String retrieveCarts(String username) {
		
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		List prodlist = sess.createQuery("from CartModel").list();
		Gson gson=new Gson();
		String jsonNames =gson.toJson(prodlist);
		tran.commit();
		sess.close();
		return jsonNames;
		
	}

	public void deleteCart(String id) {
		
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
        CartModel cartmodeldel  = (CartModel) sess.get(CartModel.class, id);//askkkk
    	sess.delete(cartmodeldel);
		tran.commit();
		sess.close();
		

	}

	public void updateCart(int id, int quantity) {
	
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		CartModel cartmodel=(CartModel)sess.get(CartModel.class,id);
		cartmodel.setQuantity(quantity);
		sess.update(cartmodel);
		tran.commit();
		sess.close();
		
		
	}

	public long getTotalPriceOfCart(String username) {
		
		long total_price;
		Session sess = sf.openSession();
		Transaction t = sess.beginTransaction();
		String hql = "select sum(price*quantity) from Cart where username = '"+username+"'";
		Query qy = sess.createQuery(hql);
		if(qy.uniqueResult()==null)
		{
			total_price = 0;
		}
		else
		{	
			total_price = (Long) qy.uniqueResult();
		}
		t.commit();
		sess.flush();
		sess.close();
		return total_price;

		
		
	}

	public long getTotalQuantityOfCart(String username) {
		
		long total_quantity;
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		String hql = "select sum(quantity) from Cart where username = '"+username+"'";
		Query qy = sess.createQuery(hql);
		if(qy.uniqueResult()==null)
		{
			total_quantity = 0;
		}
		else
		{	
			total_quantity =  (Long) qy.uniqueResult();
		}
		tran.commit();
		sess.flush();
		sess.close();
		return total_quantity;
	}


	}


