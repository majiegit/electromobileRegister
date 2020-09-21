package com.xiaoka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.Violation;
import com.xiaoka.service.ViolationService;

@Controller
public class ViolationController {

	@Autowired
	private ViolationService violationService;

	/**
	 * 开罚单
	 * 
	 * @param violation
	 * @return
	 */
	@RequestMapping(value = "/violationAdd", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg violationAdd(Violation violation) {
		CallBackMsg result = violationService.violationAdd(violation);

		return result;

	}

	/**
	 * 查罚单
	 * 
	 * @param violation
	 * @return
	 */
	@RequestMapping(value = "/violationFind", method = RequestMethod.POST)
	@ResponseBody
	public List<Violation> violationFind(@RequestParam(value = "licenseNum") String licenseNum) {
		return violationService.violationFind(licenseNum);

	}

}
