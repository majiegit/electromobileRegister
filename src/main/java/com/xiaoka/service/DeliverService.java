package com.xiaoka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.dao.OrderDao;

@Service
public class DeliverService {

	@Autowired
	private OrderDao orderDao;

	public CallBackMsg deliver(String orderId, String licenseNum) {
		CallBackMsg callBackMsg = new CallBackMsg();
		String status = "已发货";

		int changeStatus = orderDao.changeStatus(Integer.parseInt(orderId), status);
		if (changeStatus > 0) {
			orderDao.addlicenseNum(Integer.parseInt(orderId), licenseNum);
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

}
