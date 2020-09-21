package com.xiaoka.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.bean.CategoryProduct;
import com.xiaoka.bean.Product;
import com.xiaoka.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	@Value("${my.file.url}")
	private String url1;

	/**
	 * 添加基本商品基本信息
	 * 
	 * @param file
	 * @param product
	 * @return
	 */
	/*
	 * public CallBackMsg addProduct(MultipartFile file, Product product) {
	 * 
	 * 
	 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//
	 * 设置日期格式 System.out.println(df.format(new Date()));
	 * 
	 * 
	 * CallBackMsg callBackMsg = new CallBackMsg();
	 * 
	 * String fileName = file.getOriginalFilename(); // 文件名
	 * 
	 * String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
	 * String filePath = url1; fileName = UUID.randomUUID() + suffixName; //
	 * 新文件名
	 * 
	 * File dest = new File(filePath + fileName); if
	 * (!dest.getParentFile().exists()) { dest.getParentFile().mkdirs(); } try {
	 * file.transferTo(dest); } catch (IOException e) { e.printStackTrace(); }
	 * 
	 * product.setAddTime(new Date());
	 * 
	 * product.setPicture(fileName); int addProduct =
	 * productDao.addProduct(product);
	 * 
	 * if (addProduct > 0) { callBackMsg.setMsg("1");
	 * callBackMsg.setData(fileName); return callBackMsg;
	 * 
	 * } callBackMsg.setMsg("0"); return callBackMsg; }
	 */

	/**
	 * 添加商品大图信息
	 * 
	 * @param file
	 * @param picture
	 * @return
	 */
	// public CallBackMsg addProductBigP(MultipartFile file, String picture) {
	// CallBackMsg callBackMsg = new CallBackMsg();
	//
	// String fileName = file.getOriginalFilename(); // 文件名
	//
	// String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
	// String filePath = url1;
	// fileName = UUID.randomUUID() + suffixName; // 新文件名
	//
	// File dest = new File(filePath + fileName);
	// if (!dest.getParentFile().exists()) {
	// dest.getParentFile().mkdirs();
	// }
	// try {
	// file.transferTo(dest);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// int addProductBigPicture = productDao.addProductBigPicture(picture,
	// fileName);
	// if (addProductBigPicture > 0) {
	// callBackMsg.setMsg("1");
	//
	// return callBackMsg;
	// }
	//
	// callBackMsg.setMsg("0");
	// return callBackMsg;
	// }

	/**
	 * 根据商品类型 查询商品
	 * 
	 * @param category
	 * @return
	 */
	public List<Product> findProductByCategory(String category) {
		String str = new SQL() {
			{
				SELECT("p.*");			
				FROM("product p");
				INNER_JOIN("category_product c on p.product_id=c.product_id");
				INNER_JOIN("category c1 on c.category_id= c1.category_id");
				WHERE("c1.category_id = #{category}");
				WHERE("p.isShow = '是'");
			}
		}.toString();
		return productDao.showProductList(str,Integer.parseInt(category));
	}



}
