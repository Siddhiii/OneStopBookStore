package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.model.Category;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.service.CatIService;
import com.ecommerce.service.IService;


@Controller
public class CategoryController {
  
	@Autowired
	CatIService catiservice;
	
	
	@RequestMapping("category")
	public ModelAndView category() {
		ModelAndView mvc= new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();//to show the list of categories when i open the page
		mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	@RequestMapping("addcat")//should match with form(addcat) action
	public ModelAndView addcategory(Category cate)
	{
		catiservice.addcategory(cate);//linked to addproduct check the flow u'll understand
		ModelAndView mvc= new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);
		return mvc;
	
	}
	@RequestMapping(value="deletecat",method=RequestMethod.GET)
	public ModelAndView deletecategory(@RequestParam("id")int id)// the requestparam(id) should be same as href of the manageproduct delete?id
	{
		catiservice.deletecat(id);
		ModelAndView mvc=new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	@RequestMapping(value="catfetchProductById",method=RequestMethod.GET)
	public ModelAndView fetchProductbyid(@RequestParam("id")int id)// the requestparam(id) should be same as href of the manageproduct delete?id
	{
	    Category categoryobj= catiservice.catfetchProductbyid(id);
	    ModelAndView mvc=new ModelAndView("category","cat",categoryobj);
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);//prodlist should match with  ${prodlist}
		mvc.addObject("catlistupdate", true);//should match with <c:when test="${prolistupdate==true}"> so that it displays the form
		return mvc;
		
	}
	
	@RequestMapping(value="updatecate",method=RequestMethod.POST)
	public ModelAndView Updatecategory(Category ca)// 
	{
	    catiservice.updatecategory(ca);
	    ModelAndView mvc=new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);//prodlist should match with  ${prodlist}
		return mvc;
		
	}
	
	@RequestMapping(value="enable",method=RequestMethod.GET)
	public ModelAndView enable(@RequestParam("id")int id)
	{
		String status="Enable";
		catiservice.setcategorystatus(id, status);
		ModelAndView mvc=new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	@RequestMapping(value="disable",method=RequestMethod.GET)
	public ModelAndView disable(@RequestParam("id")int id)
	{
		String status="Disable";
		catiservice.setcategorystatus(id, status);
		ModelAndView mvc=new ModelAndView("category","cat",new Category());
		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	
}
