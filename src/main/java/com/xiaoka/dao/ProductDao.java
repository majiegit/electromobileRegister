package com.xiaoka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoka.bean.CategoryProduct;
import com.xiaoka.bean.Item;
import com.xiaoka.bean.Product;

public interface ProductDao {

	/**
	 * 添加商品基本信息
	 * 
	 * @param product
	 * @return
	 */
	@Insert("insert into product(name,keywords,add_time,picture,fixed_price,description) values(#{name},#{keywords},#{addTime},#{picture},#{fixedPrice},#{description})")
	public int addProduct(Product product);

	/**
	 * 添加商品大图信息
	 * 
	 * @param picture
	 * @param bigPicture
	 * @return
	 */
	@Update("update product set big_picture=#{bigPicture} where picture=#{picture}")
	public int addProductBigPicture(@Param(value = "picture") String picture,
			@Param(value = "bigPicture") String bigPicture);

	/**
	 * 查询需要显示的商品列表
	 * 
	 * @param category
	 * @return
	 */
	@Select("${str}")
	public List<Product> showProductList(@Param(value="str")String str,@Param(value="category")int category);

	/**
	 * 根据商品id查询商品
	 * 
	 * @param productId
	 * @return
	 */
	@Select("select * from product where product_id=#{productId} and isShow ='是'")
	public Product findProductById(int productId);
	
	/**
	 * 添加订单明细
	 * @param item
	 * @return
	 */
	@Insert("insert into item(order_id,product_id,product_num) values(#{orderId},#{productId},#{productNum})")
	public int addItem(Item item);
}
