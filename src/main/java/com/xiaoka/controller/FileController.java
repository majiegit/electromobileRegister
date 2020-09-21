package com.xiaoka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.service.FileService;

@Controller
public class FileController {
	@Autowired
	private FileService fileService;

	/**
	 * 上传身份证正面照片
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicPros")
	@ResponseBody
	public CallBackMsg uploadPicPros(@RequestParam("file") MultipartFile file, @RequestParam("idCard") String idCard,
			@RequestParam("isPrincipal") String isPrincipal, @RequestParam("compName") String compName) {

		CallBackMsg CM = fileService.uploadPicPros(file, idCard, isPrincipal, compName);
		return CM;

	}

	/**
	 * 个人上传身份证反面
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCons")
	@ResponseBody
	public CallBackMsg uploadPicCons(@RequestParam("file") MultipartFile file, @RequestParam("idCard") String idCard,
			@RequestParam("isPrincipal") String isPrincipal) {

		CallBackMsg CM = fileService.uploadPicCons(file, idCard, isPrincipal);
		return CM;

	}

	/**
	 * 企业上传身份证反面
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCOMPCons")
	@ResponseBody
	public CallBackMsg uploadPicCOMPCons(@RequestParam("file") MultipartFile file,
			@RequestParam("idCard") String idCard, @RequestParam("compName") String compName) {

		
		CallBackMsg CM = fileService.uploadPicCOMPCons(file, idCard, compName);
		return CM;

	}

	/**
	 * 车辆前45照片
	 * 
	 * @param file
	 * @param idCard
	 * @param compName
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCarPros")
	@ResponseBody
	public CallBackMsg uploadPicCarPros(@RequestParam("file") MultipartFile file, @RequestParam("carId") String carId,
			@RequestParam("compName") String compName, @RequestParam("isComp") String isComp) {

		CallBackMsg CM = fileService.uploadPicCarPros(file, carId, compName, isComp);
		return CM;

	}

	/**
	 * 车辆后45照片
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCarCons")
	@ResponseBody
	public CallBackMsg uploadPicCarCons(@RequestParam("file") MultipartFile file, @RequestParam("carId") String carId,
			@RequestParam("compName") String compName, @RequestParam("isComp") String isComp) {

		
		CallBackMsg CM = fileService.uploadPicCarCons(file, carId, compName, isComp);
		return CM;

	}
	
	/**
	 * 车辆发票
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCarP3")
	@ResponseBody
	public CallBackMsg uploadPicCarP3(@RequestParam("file") MultipartFile file, @RequestParam("carId") String carId) {
		
		CallBackMsg CM = fileService.uploadPicCarP3(file, carId);
		return CM;

	}
	
	/**
	 * 脚踏处照片
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCarP4")
	@ResponseBody
	public CallBackMsg uploadPicCarP4(@RequestParam("file") MultipartFile file, @RequestParam("carId") String carId) {
		
		CallBackMsg CM = fileService.uploadPicCarP4(file, carId);
		return CM;

	}
	/**
	 * 电机处照片
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	@RequestMapping(value = "/uploadPicCarP5")
	@ResponseBody
	public CallBackMsg uploadPicCarP5(@RequestParam("file") MultipartFile file, @RequestParam("carId") String carId) {
		
		CallBackMsg CM = fileService.uploadPicCarP5(file, carId);
		return CM;

	}
	
}
