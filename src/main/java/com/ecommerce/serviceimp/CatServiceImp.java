package com.ecommerce.serviceimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.CatIDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.service.CatIService;
import com.google.gson.Gson;
@Service
public class CatServiceImp implements CatIService 
{
	@Autowired
    CatIDao catidao;
	public void addcategory(Category cat) {
		
		catidao.addcategory(cat);
	}

	public String retrievecategory() {
		return catidao.retrievecategory();
		
	
	}

	public void deletecat(int id) {
		catidao.deletecat(id);
		
	}

	public Category catfetchProductbyid(int id) {
		
		return catidao.catfetchProductbyid(id);
	}

	public void updatecategory(Category catobj) {
		
		catidao.updatecategory(catobj);
		
	}

	public void setcategorystatus(int id, String status) {
		catidao.setcategorystatus(id, status);
		
	}
    

		
	
	
}

	
	
