package com.ecommerce.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserModel;
import com.ecommerce.service.CatIService;
import com.ecommerce.service.IService;
import com.ecommerce.service.SupIService;

@Controller
public class ViewController {
    static int count =1;
    String prod_name;
    double price ;
    
	@Autowired
	IService iservice;
	@Autowired
	SupIService supiservice;
	@Autowired
	CatIService catiservice;
	
   @RequestMapping("/")
	public ModelAndView index() {
        ModelAndView mvc = new ModelAndView("index");
        String prodlist = iservice.retrieveproduct();
        mvc.addObject("plist",prodlist);
        String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
		
	
	}
	
	
	@RequestMapping("about")//should match with ahref=""
	public String aboutus() {

		return "aboutus";
	}
	
	@RequestMapping("")
	public String adminpage(){
		return "adminpage";
	}
	
	
	
/*	@RequestMapping("/")
	public ModelAndView showproduct()
	{
		String fetchall=iservice.fetchAllproduct();
		ProductInfo prodinfobj=new ProductInfo();
		ModelAndView mvc=new ModelAndView("index");
        String productlist=iservice.retrieveproduct();
        mvc.addObject("prodlist",productlist);
		
		return mvc;
	}*/
	
	@RequestMapping("manageproduct")
	public ModelAndView manageproduct() {
		
		ModelAndView mvc= new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	@RequestMapping("addproduct")//should match with form(manageproduct) action
	public ModelAndView addproduct(ProductInfo proinfo)
	{
		
		if(count!=0 && proinfo.getProductname()!=prod_name && proinfo.getProductprice()!=price)
		{
			iservice.addproduct(proinfo);//linked to addproduct check the flow u'll understand
		
		count=0;
		prod_name=proinfo.getProductname();//storing prodname and price
		price=proinfo.getProductprice();
		
		String path="C:\\Users\\Nitin Gandhi\\workspace\\ecommerce\\src\\main\\webapp\\resources\\ecom_images\\";
        path=path+String.valueOf(proinfo.getProductid())+".jpg";
        File f=new File(path);
        MultipartFile mf=proinfo.getProduct_img();
        if(!mf.isEmpty())
		{
			try
			{
			  byte[] bytes=mf.getBytes();
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bos=new BufferedOutputStream(fos);
              			bos.write(bytes);
              			bos.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
        else
        {
        	System.out.println("File is Empty not Uploaded");
        }
        
        
		}
		ModelAndView mvc= new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		
	count=0;
		return mvc;
	
	}
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public ModelAndView deleteproduct(@RequestParam("id")int id)// the requestparam(id) should be same as href of the manageproduct delete?id
	{
		iservice.deleteProduct(id);
		ModelAndView mvc=new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
	}
	
	@RequestMapping(value="fetchProductById",method=RequestMethod.GET)
	public ModelAndView fetchProductbyid(@RequestParam("id")int id)// the requestparam(id) should be same as href of the manageproduct delete?id
	{
	    ProductInfo prodinfobj= iservice.fetchProductbyid(id);
	    ModelAndView mvc=new ModelAndView("manageproduct","mp",prodinfobj);
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);//prodlist should match with  ${prodlist}
		mvc.addObject("prolistupdate", true);//should match with <c:when test="${prolistupdate==true}"> so that it displays the form
		return mvc;
		
	}
	
	@RequestMapping(value="updateprod",method=RequestMethod.POST)
	public ModelAndView Updateproduct(ProductInfo pI)// 
	{
	    iservice.updateproduct(pI);
	    ModelAndView mvc=new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);//prodlist should match with  ${prodlist}
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
		
		
	}
	
	@RequestMapping(value="enableprod",method=RequestMethod.GET)
	public ModelAndView enableprod(@RequestParam("id")int id)
	{
		String status="Enable";
		iservice.setProductstatus(id, status);
		ModelAndView mvc=new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
		
	}
	
	@RequestMapping(value="disableprod",method=RequestMethod.GET)
	public ModelAndView disableprod(@RequestParam("id")int id)
	{
		String status="Disable";
		iservice.setProductstatus(id, status);
		ModelAndView mvc=new ModelAndView("manageproduct","mp",new ProductInfo());
		String productlist = iservice.retrieveproduct();
		mvc.addObject("prodlist",productlist);
		String supplierlist=supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt",supplierlist);
		String categorylist=catiservice.retrievecategory();
	    mvc.addObject("categolist",categorylist);
		return mvc;
		
	}
	

	
	
	
}