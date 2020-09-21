package com.xiaoka.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EleOrder;
import com.xiaoka.bean.Item;
import com.xiaoka.bean.Product;
import com.xiaoka.dao.OrderDao;
import com.xiaoka.dao.ProductDao;
import com.xiaoka.dao.ReferDao;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderdao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private ReferDao Referdao;

	@Value("${my.file.url}")
	private String url1;

	/**
	 * 上牌预约
	 *
	 * @param order
	 * @param product
	 * @return
	 */
	public CallBackMsg order(EleOrder eleOrder, String[] product) {
		CallBackMsg callBackMsg = new CallBackMsg();
		int mark = 0;
		int carId = eleOrder.getCarId();
		//检查车辆是否已有支付订单
		EleOrder cheakOrder = orderdao.cheakOrder(carId);

		if (null != cheakOrder) {
			callBackMsg.setMsg("-1");
			return callBackMsg;
		}

		Item item = new Item();
	    for (int i = 0; i < 10; i++) {
	    	String lock = String.valueOf((int) (89999999*Math.random()+10000000));
	    	eleOrder.setCodedLock(lock);
			EleOrder cheakLock = orderdao.cheakLock(lock);
			if(cheakLock==null){
				break;
			}

	    }
	eleOrder.setStatus("待支付");
	// 查询总价
	for (String s : product) {
		mark += productDao.findProductById(Integer.parseInt(s)).getFixedPrice();
	}
	eleOrder.setTotalPrice(mark);
	eleOrder.setAddTime(new Date());
	int od = orderdao.order(eleOrder);
	if (od > 0) {
		callBackMsg.setMsg("1");

		String codedLock = eleOrder.getCodedLock();
		int orderId = orderdao.selectOrderBycodedLock(codedLock).getOrderId();
		for (String s1 : product) {

			item.setOrderId(orderId);
			item.setProductId(Integer.parseInt(s1));
			productDao.addItem(item);
		}

		return callBackMsg;
	}
	callBackMsg.setMsg("0");
	return callBackMsg;

}

/**
 * 根据自提码查询信息
 *
 * @param codedLock
 * @return
 */
public EleOrder selectOrderBycodedLock(String codedLock) {

	return orderdao.selectOrderBycodedLock(codedLock);
}

/**
 * 根据idCard查询EleOrder信息
 *
 * @param idCard
 * @return
 */
public List<EleOrder> selectOrderByidCard(String idCard) {
	// TODO Auto-generated method stub
	return orderdao.selectOrderByidCard(idCard);
}

/**
 * idCard查询上牌预约信息状态(待支付，已支付，已办理，已上牌)
 *
 * @param order
 * @return
 */
public List<EleOrder> selectOrderByidCard1(String idCard, String status) {
	// TODO Auto-generated method stub
	return orderdao.selectOrderByidCard1(idCard, status);
}

/**
 * 根据orderid 删除订单
 *
 * @param orderId
 * @return
 */
public CallBackMsg deleteOrderByorderId(String orderId) {
	CallBackMsg callBackMsg = new CallBackMsg();
	int i = orderdao.deleteOrderByorderId(Integer.parseInt(orderId));
	if (i > 0) {
		callBackMsg.setMsg("1");
		return callBackMsg;
	}
	callBackMsg.setMsg("0");
	return callBackMsg;
}

/**
 * 人车认证
 *
 * @param file
 * @param orderId
 * @return
 */
public CallBackMsg prove(MultipartFile file, String carId, String licenseNum) {
	CallBackMsg callBackMsg = new CallBackMsg();
	//企业

	 String belong = Referdao.referCbyCarId2(Integer.parseInt(carId)).getBelong();
	 	if(belong==null||!"".equals(belong)){
	 		int orderId = orderdao.selectOrderByCarId2(Integer.parseInt(carId)).getOrderId();
	 		EleOrder licenseNumEmpty = orderdao.licenseNumEmpty(licenseNum);

	 		if(licenseNumEmpty!=null){
	 			callBackMsg.setMsg("0");
				return callBackMsg;
	 		}
	 		String fileName = file.getOriginalFilename(); // 文件名

	 		String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
	 		String filePath = url1;
			fileName = UUID.randomUUID() + suffixName; // 新文件名

			File dest = new File(filePath + fileName);
				if (!dest.getParentFile().exists()) {
					dest.getParentFile().mkdirs();
				}
				try {
					file.transferTo(dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Date finsh = new Date();
				int compNSP = orderdao.compNSP(orderId, licenseNum, fileName,finsh);
				if(compNSP==1){

					callBackMsg.setMsg("1");

					return callBackMsg;

				}


				callBackMsg.setMsg("0");

				return callBackMsg;

	}
	//个人
	// 查询 牌照认证
	EleOrder cheakLicenseNum = orderdao.cheakLicenseNum(Integer.parseInt(carId), licenseNum);
	if (null == cheakLicenseNum) {
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

	String fileName = file.getOriginalFilename(); // 文件名

	String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
	String filePath = url1;
	fileName = UUID.randomUUID() + suffixName; // 新文件名

	File dest = new File(filePath + fileName);
	if (!dest.getParentFile().exists()) {
		dest.getParentFile().mkdirs();
	}
	try {
		file.transferTo(dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	int orderId = cheakLicenseNum.getOrderId();
	orderdao.addpicProve(orderId, fileName);

	orderdao.changeStatus(orderId, "已上牌");

	callBackMsg.setMsg("1");

	return callBackMsg;
}

/**
 * 根据车辆id查找订单
 *
 * @param carId
 * @return
 */
public List<EleOrder> selectOrderBycarId(String carId) {
	return orderdao.selectOrderByCarId(Integer.parseInt(carId));

}

/**
 * 查询订单详情
 *
 * @param orderId
 * @return
 */
public List<Product> item(String orderId) {
	List<Product> listR = new ArrayList<Product>();
	List<Item> list = orderdao.item(Integer.parseInt(orderId));
	if (null != list) {
		for (Item item : list) {
			listR.add(orderdao.itemProduct(item.getProductId()));
		}
	}
	return listR;
}

/**
 * 查询行驶证
 *
 * @param carId
 * @return
 */
public EleOrder dLicence(String carId) {
	String status = "已上牌";
	return orderdao.finddLicence(Integer.parseInt(carId), status);

}

}
