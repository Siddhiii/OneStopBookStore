package com.ecommerce.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.dao.UserIDao;
import com.ecommerce.model.ProductInfo;
import com.ecommerce.model.UserCredential;
import com.ecommerce.model.UserModel;
import com.ecommerce.service.CatIService;
import com.ecommerce.service.IService;
import com.ecommerce.service.SupIService;
import com.ecommerce.service.UserCredIService;
import com.ecommerce.service.UserIService;



@Controller
public class UserController {
	@Autowired
	UserIService useriservice;
	@Autowired
	UserCredIService usercrediservice;
	@Autowired
	IService iservice;
	@Autowired
	SupIService supiservice;
	@Autowired
	CatIService catiservice;

	@RequestMapping("register")
	public ModelAndView user() {

		ModelAndView mvc = new ModelAndView("Register", "ur", new UserModel());
		return mvc;
	}

	@RequestMapping(value = "register1", method = RequestMethod.POST)
	public ModelAndView adduserreg(UserModel usermodel) {
		boolean registerationstatus;

		UserCredential usercred = new UserCredential();

		ModelAndView mvc = new ModelAndView("index");
		String prodlist = iservice.retrieveproduct();
		mvc.addObject("plist", prodlist);
		String supplierlist = supiservice.retrievesupplier();
		mvc.addObject("Supplierlistt", supplierlist);

		String categorylist = catiservice.retrievecategory();
		mvc.addObject("categolist", categorylist);

		try {
			useriservice.adduser(usermodel);
			usercred.setUsername(usermodel.getUsername());
			usercred.setPassword(usermodel.getUserpassword());
			usercred.setEnabled(true);
			usercred.setRole("ROLE_USER");
			usercrediservice.adduserc(usercred);
			registerationstatus = true;

		} catch (Exception e) {
			System.out.println("Something went wong with signin");
			registerationstatus = false;

		}
		mvc.addObject("successmessage", registerationstatus);
		return mvc;
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public ModelAndView logpage(){
		ModelAndView mvc = new ModelAndView("login","user",new UserModel());
		return mvc;
	}

	@RequestMapping(value="/validatelogin", method=RequestMethod.POST)
	public ModelAndView loginChecker(ModelAndView mav, HttpSession session)
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String role = "ROLE_USER";
		System.out.println("Person is"+ username);
		for(GrantedAuthority authority : authorities)
		{	
			if(authority.getAuthority().equals(role))
			{
				mav = new ModelAndView("index", "user", new UserModel());
				session.setAttribute("loggedinuser", username);
				session.setAttribute("userloggedin", true);
			}
			else
			{
				mav = new ModelAndView("adminpage");//should match with jsp
				session.setAttribute("loggedinuser", username);
			}


			}

		return mav;
		
	}
		
		@RequestMapping(value="/perform_logout", method=RequestMethod.GET)
		public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response)
		{
			session=request.getSession();
			session.invalidate();
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    
			ModelAndView mav = new ModelAndView("index", "user", new UserModel());
			return mav;
		}
		
		@RequestMapping("/loginerror")
		public ModelAndView loginError()
		{
			ModelAndView mav = new ModelAndView("login", "user", new UserModel());
			mav.addObject("error", "Invalid login! Please try again");
			return mav;
		}
		
		@RequestMapping("/accessdenied")
		public ModelAndView accessDenied(HttpSession session)
		{
			ModelAndView mav = new ModelAndView("index", "user", new UserModel());
			mav.addObject("error", "You are not authorized to access this page");
			return mav;
		}

}