package com.xiaoka.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.bean.EleOrder;
import com.xiaoka.dao.OrderDao;
import com.xiaoka.dao.ReferDao;
import com.xiaoka.dao.RegisterDao;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired 
	private OrderDao orderDao;
	
	@Autowired
	private ReferService referService;

	/**
	 * 获取所有个人信息
	 * 
	 * @return
	 */
	public String getAll() {
		List<EBP> all = registerDao.getAll();
		System.out.println(all);
		return " ";
	}

	/**
	 * 添加个人信息
	 * 
	 * @param ebp
	 * @return 添加个人信息
	 */
	public CallBackMsg regist(EBP ebp) {
		CallBackMsg callBackMsg = new CallBackMsg();
		String idCard = ebp.getIdCard();
		// 检查身份证是否重复
		EBP selectIdCard = registerDao.selectIdCard(idCard);

		if (null == selectIdCard) {
			int result = registerDao.regist(ebp);
			callBackMsg.setMsg("1");
			callBackMsg.setData(idCard);
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

	/**
	 * 添加车辆信息
	 * 
	 * @param ebc
	 * @return CallBackMsg
	 */
	public CallBackMsg regist1(EBC ebc) {
		CallBackMsg callBackMsg = new CallBackMsg();
		String idCard = ebc.getIdCard();
		String brand = ebc.getBrand();
		String carBodyNum = ebc.getCarBodyNum();
		String carEleNum = ebc.getCarEleNum();
		// 检测身份证注册上限 （每人3个）
		int selectCarIdCard = registerDao.selectCarIdCard(idCard);
		if (selectCarIdCard > 2) {
			callBackMsg.setMsg("0");
			return callBackMsg;
		}
		// 检查车辆车架号使用程度
		if(!"".equals(carBodyNum)){
			int selectCarBodyNum = registerDao.selectCarBodyNum(brand, carBodyNum);
			if (selectCarBodyNum > 0) {
				callBackMsg.setMsg("-1");
				return callBackMsg;
			}	
		}
		
	
		if(!"".equals(carEleNum)){
			int selectCarEleNum = registerDao.selectCarEleNum(brand, carEleNum);
			if (selectCarEleNum > 0) {
				callBackMsg.setMsg("-2");
				return callBackMsg;
			}
		}
		
		// 检测是否为企业车辆
		String belong = ebc.getBelong();

		//个人车辆注册
		if (null == belong||"".equals(belong)) {
			int registCar = registerDao.registCar(ebc);
			
			if(registCar>0){
				callBackMsg.setMsg("1");
				int carid = registerDao.selectCarid(ebc);
				callBackMsg.setData(Integer.toString(carid));
				return callBackMsg;
			}else {
				callBackMsg.setMsg("-3");
				callBackMsg.setData("注册失败");
				return callBackMsg;
			}		
		}
		
		//企业车辆注册
		EleOrder order = new EleOrder();
		registerDao.registCompCar(ebc);
		
		//返回车辆id
		int carid = registerDao.selectCarid(ebc);
		//返回企业名称
		 String compName = referService.referComp(belong).getCompName();
		
		//填写order信息
		order.setCarId(carid);
		order.setUsername(compName);
		order.setStatus("已支付");
		Date date = new Date();
		order.setAddTime(date);
		order.setType("企业上牌");
		//注册车辆order
		int order2 = orderDao.order(order);
		if(order2 > 0){
			callBackMsg.setMsg("1");
			callBackMsg.setData(Integer.toString(carid));
			return callBackMsg;
					}
		callBackMsg.setMsg("-3");
		callBackMsg.setData("注册失败");
		return callBackMsg;

	}

	

}
