package com.xiaoka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.dao.LoginDao;

@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;

	/**
	 * 个人登陆
	 * 
	 * @param userName
	 * @param idCard
	 * @return 成功返回1 失败返回0
	 */
	public CallBackMsg Plogin(String userName, String idCard) {
		CallBackMsg callBackMsg = new CallBackMsg();
		EBP plogin = loginDao.Plogin(userName, idCard);
		if (null == plogin) {
			callBackMsg.setMsg("0");
			return callBackMsg;
		}
		callBackMsg.setData(plogin.getIdCard());
		callBackMsg.setMsg("1");
		return callBackMsg;
	}

	/**
	 * 企业登录
	 * 
	 * @param count
	 * @param password
	 * @return 成功返回1，企业id 失败返回0
	 */
	public CallBackMsg compLogin(String count, String password) {
		CallBackMsg callBackMsg = new CallBackMsg();
		EBCOMP ebcomp = loginDao.compLogin(count, password);

		if (null == ebcomp) {
			callBackMsg.setMsg("0");
			return callBackMsg;
		}
		callBackMsg.setData(Integer.toString(ebcomp.getId()));
		callBackMsg.setMsg("1");
		return callBackMsg;
	}

}
