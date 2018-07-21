
package com.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DropdownController {

	
	   private ModelAndView mav;
	   
	   private void syso() {
		System.out.println("niteennnxscbbsucdyhbcjc hi   anya");
		System.out.println("hiii");
	}
	   
	   
	   
	/*
	@RequestMapping(value="/DropdownList")
	public String m1()
	{
		
		System.out.println("m1 method in controller");
		
		return "DropdownPage";
	}
	
	@RequestMapping(value="/CountryMethod", method = RequestMethod.GET)
	public ModelAndView Country()
	{
		mav=new ModelAndView();
				System.out.println("m2 country method in controller");
				 Map<String, String> us = new LinkedHashMap<String, String>();
				    us.put("1", "Washington");
				  
				    us.put("2", "New York");
				
				
		mav.addObject("countryList", us);
		return  mav;
	}
*/	
	
	
}
