package com.ecommerce.daoimp;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.IDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;
import com.google.gson.Gson;
@Repository
public class DaoImp implements IDao{
@Autowired
SessionFactory sf;
	public void addproduct(ProductInfo prodinfo) {
	  
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.save(prodinfo);
		tran.commit();
		sess.flush();
		sess.close();
	}
	
	public String retrieveproduct()
	{
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		List prodlist = sess.createQuery("from ProductInfo").list();
		Gson gson=new Gson();
		String jsonNames =gson.toJson(prodlist);
		tran.commit();
		sess.close();
		return jsonNames;
		
	}
	
	
	
	/*public ProductInfo fetchProductById(int id) //ProductInfo because it has to be the class in which you had made columns
	{
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		ProductInfo prolist=(ProductInfo) sess.get(ProductInfo.class,id);
		tran.commit();
		sess.close();
		return prolist;
	}*/
	
	public void deleteProduct(int id)

	 {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
        ProductInfo prodel  = (ProductInfo) sess.get(ProductInfo.class, id);//askkkk
    	sess.delete(prodel);
		tran.commit();
		sess.close();
		
	 }

	public ProductInfo fetchProductbyid(int id)
	{
	   
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		ProductInfo prolist=(ProductInfo) sess.get(ProductInfo.class,id);
		tran.commit();
		sess.close();
		return prolist;
	}

	public void updateproduct(ProductInfo proobj) 
	{
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.update(proobj);
		tran.commit();
		sess.close();
		
	}

	public void productstatus(int id, String status) {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		ProductInfo prodlist=(ProductInfo) sess.get(ProductInfo.class,id);
		prodlist.setProductstatus(status);
		tran.commit();
		sess.close();
	}

	public String fetchAllproduct() {
		Session sess = sf.openSession();
		Query qry = sess.createQuery("From ProductInfo");
		List list = (List)qry.list();
		
		Gson gson = new Gson();
		String productList = gson.toJson(list);
		sess.close();
		return productList;
	}
	
/*	public ProductInfo updateProduct(ProductInfo prodinfoobj){
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
        ProductInfo proupdate  = (ProductInfo) sess.get(ProductInfo.class, prodinfoobj);
		sess.update(proupdate);	
		tran.commit();
		sess.close();
	}*/

	
	
}
