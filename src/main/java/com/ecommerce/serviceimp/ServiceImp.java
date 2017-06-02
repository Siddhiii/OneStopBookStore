package com.ecommerce.serviceimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;
import com.ecommerce.service.IService;

@Service

public class ServiceImp implements IService{
@Autowired
    IDao idao;
	public void addproduct(ProductInfo prodinfo) {
		idao.addproduct(prodinfo);
		
	}
	public String retrieveproduct()
	{
		return idao.retrieveproduct();
	}
	
	public void deleteProduct(int id)
	{
		idao.deleteProduct(id);
	}
	public ProductInfo fetchProductbyid(int id) {
		
		return idao.fetchProductbyid(id);
	}
	public void updateproduct(ProductInfo proobj) {
		
		idao.updateproduct(proobj);
		
	}
	public void setProductstatus(int id, String status) {
		idao.productstatus(id, status);
		
	}
	public String fetchAllproduct() {
		
		return idao.fetchAllproduct();
	}
	
	
	
}
