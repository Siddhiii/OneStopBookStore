package com.ecommerce.dao;

import com.ecommerce.model.Category;

public interface CatIDao 
{

	void addcategory(Category cat);
	 String retrievecategory();
	 void deletecat(int id);
	 Category catfetchProductbyid(int id);
	 void updatecategory(Category catobj);
	 void setcategorystatus(int id,String status);
}
