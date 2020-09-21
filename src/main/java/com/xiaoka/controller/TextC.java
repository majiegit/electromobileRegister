package com.xiaoka.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoka.bean.EleOrder;
import com.xiaoka.dao.OrderDao;

@Controller
@CrossOrigin
public class TextC {
	@Autowired
	private OrderDao orderdao;
	
	@RequestMapping(value= "/test",method=RequestMethod.POST)
	@ResponseBody
	public void test(HttpServletRequest httpServletRequest){
		String carId = httpServletRequest.getParameter("carid");
		String licenseNum = httpServletRequest.getParameter("licenseNum");
		
	/*	EleOrder cheakLicenseNum = orderdao.cheakLicenseNum(Integer.parseInt(carId), licenseNum);
		System.out.println(cheakLicenseNum);
	       if(null==cheakLicenseNum){
	    	   System.out.println("0");
	       }
	*/
		
	}
	

	
	
}
