package com.ecommerce.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.SupIDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;
import com.ecommerce.service.SupIService;


@Service
public class SupServiceImp implements SupIService {
	
	@Autowired
    SupIDao supidao;
	public void SaveSupplier(Supplier supobj)
	{
		supidao.SaveSupplier(supobj);
	}
	
	public String retrievesupplier() 
	{
		return supidao.retrievesupplier();
	}
	public void deletesup(int id) {
		
		supidao. deletesup(id);
	}

    public Supplier supfetchproductbyid(int id)
    {
		return supidao.supfetchproductbyid(id);
	}

	public void updatesup(Supplier sup) 
	{
		supidao.updatesup(sup);
	}
}
