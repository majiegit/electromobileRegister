package com.xiaoka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.EleOrder;
import com.xiaoka.bean.Product;
import com.xiaoka.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;

	/**
	 * 上牌预约
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg order(EleOrder eleOrder, @RequestParam(value = "product") String[] product) {

		CallBackMsg result = orderService.order(eleOrder, product);

		return result;

	}

	/**
	 * 自提码查询上牌预约信息
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/selectOrderBycodedLock", method = RequestMethod.POST)
	@ResponseBody
	public EleOrder selectOrderBycodedLock(@RequestParam(value = "codedLock") String codedLock) {

		return orderService.selectOrderBycodedLock(codedLock);

	}

	/**
	 * idCard查询上牌预约信息
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/selectOrderByidCard", method = RequestMethod.POST)
	@ResponseBody
	public List<EleOrder> selectOrderByidCard(@RequestParam(value = "idCard") String idCard) {

		return orderService.selectOrderByidCard(idCard);

	}

	/**
	 * carId查询上牌预约信息
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/selectOrderBycarId", method = RequestMethod.POST)
	@ResponseBody
	public List<EleOrder> selectOrderBycarId(@RequestParam(value = "carId") String carId) {

		return orderService.selectOrderBycarId(carId);

	}

	/**
	 * idCard查询上牌预约信息状态(未支付，已支付，已发货，已完成)
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/selectOrderByidCard1", method = RequestMethod.POST)
	@ResponseBody
	public List<EleOrder> selectOrderByidCard1(@RequestParam(value = "idCard") String idCard, String status) {

		return orderService.selectOrderByidCard1(idCard, status);

	}

	/**
	 * 根据orderid 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/deleteOrderByorderId", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg deleteOrderByorderId(@RequestParam(value = "orderId") String orderId) {

		return orderService.deleteOrderByorderId(orderId);

	}

	/**
	 * 人车认证 生成行驶证
	 * 
	 * @param file
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/prove", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg prove(@RequestParam("file") MultipartFile file, @RequestParam(value = "carId") String carId,
			@RequestParam(value = "licenseNum") String licenseNum) {
		CallBackMsg callBackMsg = orderService.prove(file, carId, licenseNum);
		return callBackMsg;
	}

	/**
	 * 查询行驶证 dLicence
	 */
	@RequestMapping(value = "/dLicence", method = RequestMethod.POST)
	@ResponseBody
	public EleOrder dLicence(@RequestParam(value = "carId") String carId) {

		return orderService.dLicence(carId);

	}

	/**
	 * 查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	@ResponseBody
	public List<Product> item(@RequestParam(value = "orderId") String orderId) {
		return orderService.item(orderId);

	}

}
