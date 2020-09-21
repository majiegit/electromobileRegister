package com.xiaoka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.service.RegisterService;

@RestController
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	/**
	 * 个人信息注册
	 * 
	 * @param ebp
	 * @return CallBackMsg
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg regist(EBP ebp) {
		CallBackMsg result = registerService.regist(ebp);

		return result;

	}

	/**
	 * 车辆信息注册
	 * 
	 * @param ebc
	 * @return CallBackMsg
	 */
	@RequestMapping(value = "registCar", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg regist1(EBC ebc) {
		CallBackMsg result = registerService.regist1(ebc);
		return result;
	}

	

}
