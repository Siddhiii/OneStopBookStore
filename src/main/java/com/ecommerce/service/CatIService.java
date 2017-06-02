package com.ecommerce.service;

import com.ecommerce.model.Category;

public interface CatIService {

	void addcategory(Category cat);
	 String retrievecategory();
	 void deletecat(int id);
	 Category catfetchProductbyid(int id);
	 void updatecategory(Category catobj);
	void setcategorystatus(int id, String status);
}
