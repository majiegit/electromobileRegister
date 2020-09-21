package com.xiaoka.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.CarInfo;
import com.xiaoka.bean.IdCardInfo;
import com.xiaoka.dao.FileDao;

@Service
public class FileService {

	@Autowired
	private FileDao fileDao;

	@Value("${my.file.url}")
	private String url1;

	/**
	 * 上传身份证正面
	 * 
	 * @param file
	 * @param idCard
	 * @param isPrincipal
	 * @return
	 */
	public CallBackMsg uploadPicPros(MultipartFile file, String idCard, String isPrincipal, String compName) {
		CallBackMsg callBackMsg = new CallBackMsg();

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
		IdCardInfo idCardInfo = new IdCardInfo();
		idCardInfo.setIdcard(idCard);
		idCardInfo.setIsPrincipal(isPrincipal);
		idCardInfo.setIdcardPros(fileName);
		idCardInfo.setCompName(compName);
		int idcardPicPROS = fileDao.idcardPicPROS(idCardInfo);
		if (idcardPicPROS == 0) {
			callBackMsg.setMsg("0");
		}
		callBackMsg.setMsg("1");

		return callBackMsg;
	}

	/**
	 * 个人上传身份证反面
	 * 
	 * @param file
	 * @param idCard
	 * @return
	 */
	public CallBackMsg uploadPicCons(MultipartFile file, String idCard, String isPrincipal) {
		CallBackMsg callBackMsg = new CallBackMsg();
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
		int idcardPicCons = fileDao.idcardPicCons(fileName, idCard, isPrincipal);
		if (idcardPicCons == 0) {
			callBackMsg.setMsg("0");
		}
		callBackMsg.setMsg("1");

		return callBackMsg;
	}

	/**
	 * 企业上传身份证反面
	 * 
	 * @param file
	 * @param idCard
	 * @return
	 */
	public CallBackMsg uploadPicCOMPCons(MultipartFile file, String idCard, String compName) {
		CallBackMsg callBackMsg = new CallBackMsg();
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
		int idcardPicCons = fileDao.idcardPicCOMPCons(fileName, idCard, compName);
		if (idcardPicCons == 0) {
			callBackMsg.setMsg("0");
		}
		callBackMsg.setMsg("1");

		return callBackMsg;
	}

	/**
	 * 上传车辆前45
	 * 
	 * @param file
	 * @param carId
	 * @param compName
	 * @param isCOMP
	 * @return
	 */
	public CallBackMsg uploadPicCarPros(MultipartFile file, String carId, String compName, String isCOMP) {
		CallBackMsg callBackMsg = new CallBackMsg();
		CarInfo carInfo = new CarInfo();

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
		carInfo.setCarId(Integer.parseInt(carId));
		carInfo.setCarP1(fileName);
		carInfo.setIsComp(isCOMP);
		carInfo.setCompName(compName);
		int idcardPicCarPROS = fileDao.idcardPicCarPROS(carInfo);
		if (idcardPicCarPROS > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

	/**
	 * 上传车辆后45
	 * 
	 * @param file
	 * @param carId
	 * @param compName
	 * @param isComp
	 * @return
	 */
	public CallBackMsg uploadPicCarCons(MultipartFile file, String carId, String compName, String isComp) {
		CallBackMsg callBackMsg = new CallBackMsg();
		CarInfo carInfo = new CarInfo();

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
		int idcardPicCarCONS = fileDao.idcardPicCarCONS(fileName, Integer.parseInt(carId));
		if (idcardPicCarCONS > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}
	
	/**
	 * 车辆发票
	 * 
	 * @param file
	 * @param carId
	 * @param compName
	 * @param isComp
	 * @return
	 */
	public CallBackMsg uploadPicCarP3(MultipartFile file, String carId) {
		CallBackMsg callBackMsg = new CallBackMsg();
		CarInfo carInfo = new CarInfo();

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
		int idcardPicCarCONS = fileDao.uploadPicCarP3(fileName, Integer.parseInt(carId));
		if (idcardPicCarCONS > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}

	/**
	 * 脚踏处
	 * @param file
	 * @param carId
	 * @return
	 */
	public CallBackMsg uploadPicCarP4(MultipartFile file, String carId) {
		CallBackMsg callBackMsg = new CallBackMsg();
		CarInfo carInfo = new CarInfo();

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
		int idcardPicCarCONS = fileDao.uploadPicCarP4(fileName, Integer.parseInt(carId));
		if (idcardPicCarCONS > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}
	
	/**
	 * 电机处
	 * @param file
	 * @param carId
	 * @return
	 */
	public CallBackMsg uploadPicCarP5(MultipartFile file, String carId) {
		CallBackMsg callBackMsg = new CallBackMsg();
		CarInfo carInfo = new CarInfo();

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
		int idcardPicCarCONS = fileDao.uploadPicCarP5(fileName, Integer.parseInt(carId));
		if (idcardPicCarCONS > 0) {
			callBackMsg.setMsg("1");
			return callBackMsg;
		}
		callBackMsg.setMsg("0");
		return callBackMsg;
	}


}
