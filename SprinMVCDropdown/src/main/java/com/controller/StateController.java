package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CountryBean;
import com.bean.StateBean;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.service.StateServiceImpl;

/**
 *
 * @author rajnikant panchal
 */

@Controller
public class StateController {

	
	 @Autowired
	    private StateServiceImpl stateService;
	    //private ModelAndView mav;
/*
	    @RequestMapping(value = "/DropdownList", method = RequestMethod.GET)
	    public ModelAndView loadCountry() {

	      //  mav = new ModelAndView();
	        
	   List  ls 	=stateService.listCountry();
	        
	        //mav.addObject("countryList", stateService.listCountry());
	        
	   
	   System.out.println("after selecting country====");
	        return new ModelAndView("DropdownPage","countryList",ls);
	    }

	   
	    @RequestMapping(value = "/loadStates", headers = "Accept=*///", method = RequestMethod.GET)
	     
/*	     public @ResponseBody String loadStates(@RequestParam(value = "countryId", required = true) Integer countryId) throws IllegalStateException {
	    	
	    
	    		    	
	    
	
	    
	    System.out.println("in state================ selection");
	        //Specify the returning object you want here
	    ArrayList ls=new ArrayList<>();
	    
	    		ls=(ArrayList) stateService.loadState(countryId);
	    
	        return ls.toString();
	    	    
	    }
*/	
	 
	 
	 Integer cid;
	 
	 Integer sid;
	 
	   @RequestMapping(value = "/DropdownList", method = RequestMethod.GET)
	    public ModelAndView touchOnpage (HttpServletRequest request, HttpServletResponse response) {

	
	   	return new  ModelAndView("DropdownPage");
	   }
	
	   
	   
   @RequestMapping(value = "/CountryMethod", method = RequestMethod.GET)
   @ResponseBody
	    public void loadCountry(HttpServletRequest request, HttpServletResponse response) throws IOException {

		   System.out.println("country controler");
			 
			String country=request.getParameter("countryname");
			Map<String, String> cuntryMap = new LinkedHashMap<String, String>();
			
			
			System.out.println("country name==="+country);
		   
			List  ls 	=stateService.listCountry();
			
			String cname="";
			
			String ctrname="";
			Iterator itr=ls.iterator();
			
			while(itr.hasNext())
			{
				
				CountryBean ctr=(CountryBean) itr.next();
				
				cname=ctr.getCountryName();
				//===============main logic==============================
				if(country.equals(cname))
				{
					cid=ctr.getCountryId(); // here take id for selecting state record according to country selection
				
					ctrname=cname;
					cuntryMap.put("1", ctrname);
					
					System.out.println("in if statemete===="+ctrname);
				}
			}
			

			Map<String, String> reset = new LinkedHashMap<String, String>();
		    reset.put("1", "Select State");//here check index

		    //====================== state data come=======================
		    String sname="";
			
			Map<Integer, String> stateMap = new LinkedHashMap<Integer, String>();
			
			 ArrayList ls1=new ArrayList<>();
			    
	    		ls1=(ArrayList) stateService.loadState(cid); //  load sstate list here
	    	
	   System.out.println(ls1); 	
	    	Iterator itr1=ls1.iterator();
	    	int i=1;

	    	while(itr1.hasNext())
	    	{
	    	
	    		StateBean	st1	= (StateBean) itr1.next();
	    		
	    		int it=st1.getStateId();
	    	String	st=st1.getStateName();
	    //	String st	=(String) itr1.next();
	    		
	        // sname=	st.getStateName();
	     
	         stateMap.put(i, st);
			 i++;
			 System.out.println("state id==="+it);
	         System.out.println("state name====="+st);
	    	}
	    	   	
	   
			Map<String, String> reset1 = new LinkedHashMap<String, String>();
			reset1.put("0", "Select city");//here check index

//			stateMap.put("1", ls1.toString());
		    String json = null ;
		   // if(state.equals(sname)){ 
		    	json= new Gson().toJson(stateMap);   
		   // }
		    System.out.println("        "+json.toString());
		    response.setContentType("application/json");// transfer data to jsp page
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
				    
		    
	   }	
   
   
   
   
   
}
