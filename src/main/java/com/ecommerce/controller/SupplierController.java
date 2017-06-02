package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.Supplier;
import com.ecommerce.service.IService;
import com.ecommerce.service.SupIService;
@Controller
public class SupplierController {
	@Autowired
	SupIService supiservice;
	
	
	@RequestMapping("supplier")
	public ModelAndView manageproduct() {
		ModelAndView mvc= new ModelAndView("supplier","supplier",new Supplier());
		String supplist = supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplist);//Supplierlist should match with supplier form var sup = ${Supplierlist};
		return mvc;
	}
	
	@RequestMapping("SaveSupplier")//should match with form(manageproduct) action (retrieving)
	public ModelAndView SaveSupplier(Supplier suppl)
	{
		supiservice.SaveSupplier(suppl);//linked to addproduct check the flow u'll understand
		ModelAndView mvc= new ModelAndView("supplier","supplier",new Supplier());
		String supplist =supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplist);
		return mvc;
	
	}
	
	@RequestMapping(value="deletesup",method=RequestMethod.GET)
	public ModelAndView deletesup(@RequestParam("s_id")int s_id)// the requestparam(id) should be same as href of the manageproduct delete?id
	{
		supiservice.deletesup(s_id);//("s_id")int s_id should match with deleteProduct(s_id)
		ModelAndView mvc= new ModelAndView("supplier","supplier",new Supplier());
		String supplist =supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplist);
		return mvc;
	}
	
	@RequestMapping(value="supfetchProductById", method=RequestMethod.GET)
	public ModelAndView supfetchproductbyid(@RequestParam("s_id")int s_id)
	{
		    Supplier supobj= supiservice.supfetchproductbyid(s_id);
		    ModelAndView mvc=new ModelAndView("supplier","supplier",supobj);
			String supplist = supiservice.retrievesupplier();
			mvc.addObject("Supplierlistt",supplist);
			mvc.addObject("suplistupdate", true);//should match with <c:when test="${prolistupdate==true}"> so that it displays the form
			return mvc;
	}
	
	@RequestMapping(value="updatesup",method=RequestMethod.POST)
	public ModelAndView Updatesup(Supplier sup)// 
	{
	    supiservice.updatesup(sup);
	    ModelAndView mvc=new ModelAndView("supplier","supplier",new Supplier());
		String supplist = supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplist);
		return mvc;
	
	}
	
	
}
