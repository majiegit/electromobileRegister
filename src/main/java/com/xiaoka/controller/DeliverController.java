package com.xiaoka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.service.DeliverService;

@Controller
public class DeliverController {

	@Autowired
	private DeliverService deliverService;

	@RequestMapping(value = "/deliver", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg pay(@RequestParam(value = "orderId") String orderId,
			@RequestParam(value = "licenseNum") String licenseNum) {
		return deliverService.deliver(orderId, licenseNum);
	}

}
