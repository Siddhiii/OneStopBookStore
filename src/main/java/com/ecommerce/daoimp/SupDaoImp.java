package com.ecommerce.daoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.dao.SupIDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;
import com.google.gson.Gson;

@Repository
public class SupDaoImp implements SupIDao{

	@Autowired
	SessionFactory sf;
	
	public void SaveSupplier(Supplier supobj)

	{
		Session con = sf.openSession();
		Transaction tran = con.beginTransaction();
		con.save(supobj);
		tran.commit();
		con.close();
	
	}
	
	public String retrievesupplier() 

	{
        Session con = sf.openSession();
        Transaction tran = con.beginTransaction();
		List supplierlist = con.createQuery("FROM Supplier").list();
		Gson gson = new Gson();
		String jsonNames = gson.toJson(supplierlist);
		tran.commit();
		con.close();
		return jsonNames;

	}
	
	public void deletesup(int id)

	 {
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		Supplier supdel  = (Supplier) sess.get(Supplier.class, id);
   	    sess.delete(supdel);
		tran.commit();
		sess.close();
		
	 }
	
	public Supplier supfetchproductbyid(int id)
	{
	   
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		Supplier suplist=(Supplier) sess.get(Supplier.class,id);
		tran.commit();
		sess.close();
		return suplist;
	}

	public void updatesup(Supplier supobj) 
	{
		Session sess = sf.openSession();
		Transaction tran = sess.beginTransaction();
		sess.update(supobj);
		tran.commit();
		sess.close();
		
	}


}
