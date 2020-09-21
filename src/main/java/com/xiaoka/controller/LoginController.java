package com.xiaoka.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;

	/**
	 * 注册用户登陆
	 * 
	 * @param httpServletRequest
	 * @return 成功返回1 未注册返回0
	 */
	@RequestMapping(value = "/Plogin", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg login(HttpServletRequest httpServletRequest) {

		return loginService.Plogin(httpServletRequest.getParameter("userName"),
				httpServletRequest.getParameter("idCard"));
	}
	
	/**
	 * 企业用户登录
	 * @param httpServletRequest
	 * @return
	 */
	@RequestMapping(value = "/compLogin", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg compLogin(HttpServletRequest httpServletRequest) {

		return loginService.compLogin(httpServletRequest.getParameter("count"),
				httpServletRequest.getParameter("password"));

	}
}
