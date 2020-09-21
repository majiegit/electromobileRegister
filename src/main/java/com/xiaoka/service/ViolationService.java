package com.xiaoka.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.Violation;
import com.xiaoka.dao.ViolationDao;

@Service
public class ViolationService {
	@Autowired
	private ViolationDao violationDao;

	/**
	 * 开罚单
	 * 
	 * @param violation
	 * @return
	 */
	public CallBackMsg violationAdd(Violation violation) {
		CallBackMsg callBackMsg = new CallBackMsg();
		violation.setViolationDate(new Date());
		int i = violationDao.violationAdd(violation);
		if (i > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

	/**
	 * 查罚单
	 * 
	 * @param licenseNum
	 * @return
	 */
	public List<Violation> violationFind(String licenseNum) {
		return violationDao.violationFind(licenseNum);
	}

}
