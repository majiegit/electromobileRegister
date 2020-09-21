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
import com.xiaoka.bean.Product;
import com.xiaoka.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	/**
	 * 添加商品信息
	 * 
	 * @param file
	 * @param product
	 * @return
	 */
/*	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg addProduct(@RequestParam("file") MultipartFile file, Product product) {
		CallBackMsg callBackMsg = productService.addProduct(file, product);
		return callBackMsg;
	}

	*//**
	 * 添加商品大图信息
	 * 
	 * @param file
	 * @param picture
	 * @return
	 *//*
	@RequestMapping(value = "/addProductBigP", method = RequestMethod.POST)
	@ResponseBody
	public CallBackMsg addProductBigP(@RequestParam("file") MultipartFile file,
			@RequestParam("picture") String picture) {
		CallBackMsg callBackMsg = productService.addProductBigP(file, picture);
		return callBackMsg;
	}*/

	/**
	 * 根据分类查找商品
	 * 
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/findProductByCategory", method = RequestMethod.POST)
	@ResponseBody
	public List<Product> findProductByCategory(@RequestParam("category") String category) {
		return productService.findProductByCategory(category);

	}

}
