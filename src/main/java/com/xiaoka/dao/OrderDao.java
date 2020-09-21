package com.xiaoka.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xiaoka.bean.EleOrder;
import com.xiaoka.bean.Item;
import com.xiaoka.bean.Product;

public interface OrderDao {
	/**
	 * 上牌预约表 基本信息
	 * 
	 * @param order
	 * @return
	 */
	@Insert("insert into ele_order(POPS_ID,CAR_ID,IDCARD,USERNAME,PROVINCE,CITY,AREA,STREET,ADDRESS,PHONE_NUM,CODED_LOCK,STATUS,TOTAL_PRICE,addTime,type) values (#{popsId},#{carId},#{idcard},#{username},#{province},#{city},#{area},#{street},#{address},#{phoneNum},#{codedLock},#{status},#{totalPrice},#{addTime},#{type})")
	public int order(EleOrder order);

	/**
	 * 根据自提码查询订单
	 * 
	 * @param codedLock
	 * @return
	 */
	@Select("select * from ele_order where CODED_LOCK=#{codedLock}")
	public EleOrder selectOrderBycodedLock(String codedLock);

	/**
	 * 根据idCard查询EleOrder信息
	 * 
	 * @param idCard
	 * @return
	 */
	@Select("select * from ele_order where IDCARD=#{idCard}")
	public List<EleOrder> selectOrderByidCard(String idCard);

	/**
	 * idCard查询上牌预约信息状态(未支付，已支付，已发货，已完成)
	 * 
	 * @param idCard
	 *            status
	 * @return
	 */
	@Select("select * from ele_order where IDCARD=#{idCard} and STATUS=#{status}")
	public List<EleOrder> selectOrderByidCard1(@Param(value = "idCard") String idCard,
			@Param(value = "status") String status);

	/**
	 * 根据orderid 删除订单
	 * 
	 * @param orderId
	 * @return
	 */
	@Delete("delete from ele_order where ORDER_ID = #{orderId}")
	public int deleteOrderByorderId(int orderId);

	/**
	 * 修改status
	 * 
	 * @param parseInt
	 * @return
	 */
	@Update("update ele_order set STATUS =#{status} where ORDER_ID=#{orderId}")
	public int changeStatus(@Param(value = "orderId") int orderId, @Param(value = "status") String status);

	/**
	 * 发牌
	 * 
	 * @param orderId
	 * @param licenseNum
	 */
	@Update("update ele_order set LICENSE_NUM =#{licenseNum} where ORDER_ID=#{orderId}")
	public void addlicenseNum(@Param(value = "orderId") int orderId, @Param(value = "licenseNum") String licenseNum);

	
	/**
	 * 牌照使用度
	 */
	@Select("select * from ele_order where LICENSE_NUM =#{licenseNum}")
	public EleOrder licenseNumEmpty(@Param(value = "licenseNum") String licenseNum);
			
	
	/**
	 * 企业人车合照发牌
	 * @param orderId
	 * @param licenseNum
	 */
	@Update("update ele_order set LICENSE_NUM =#{licenseNum},PIC_PROVE =#{picProve},STATUS ='已上牌',finishTime=#{finsh} where ORDER_ID=#{orderId}")
	public int compNSP(@Param(value = "orderId") int orderId, @Param(value = "licenseNum") String licenseNum,@Param(value = "picProve") String picProve,@Param(value = "finsh") Date finsh);
	/**
	 * add人车认证
	 * 
	 * @param orderId
	 * @param picProve
	 */
	@Update("update ele_order set PIC_PROVE =#{picProve} where ORDER_ID=#{orderId}")
	public int addpicProve(@Param(value = "orderId") int orderId, @Param(value = "picProve") String picProve);

	/**
	 * 牌照车辆查询
	 */
	@Select("select * from ele_order where CAR_ID=#{carId} and LICENSE_NUM=#{licenseNum}")
	public EleOrder cheakLicenseNum(@Param(value = "carId") int carId, @Param(value = "licenseNum") String licenseNum);

	/**
	 * 查询订单合理插入
	 * 
	 * @return
	 */
	@Select("select * from ele_order where CAR_ID=#{carId} and STATUS='已支付'")
	public EleOrder cheakOrder(@Param(value = "carId") int carId);
	
	/**
	 * 检查订单号重复
	 * @param lock
	 */
	@Select("select * from ele_order where CODED_LOCK=#{lock}")
	public EleOrder cheakLock(String lock);
	/**
	 * 根据车辆id查找订单
	 * 
	 * @param parseInt
	 * @return
	 */
	@Select("select * from ele_order where CAR_ID=#{carId}")
	public List<EleOrder> selectOrderByCarId(int parseInt);

	/**
	 * 查询订单item详情
	 * 
	 * @return
	 */
	@Select("select * from item where ORDER_ID=#{orderId}")
	public List<Item> item(int orderId);

	/**
	 * 查找订单的商品
	 * 
	 * @param productId
	 * @return
	 */
	@Select("select * from product where product_id = #{productId}")
	public Product itemProduct(int productId);

	/**
	 * 查询行驶证
	 * 
	 * @param parseInt
	 * @param status
	 * @return
	 */
	@Select("select * from ele_order where CAR_ID=#{carId} and STATUS=#{status}")
	public EleOrder finddLicence(@Param(value = "carId") int carId, @Param(value = "status") String status);

	/**
	 * 检查支付状况 获取车辆id
	 * @param orderId
	 * @return
	 */
	@Select("select CAR_ID from ele_order where ORDER_ID=#{orderId}")
	public int getCarId(String orderId);
	
	/**
	 * 检查支付状况 获取车辆id
	 * @param orderId
	 * @return
	 */
	@Select("select * from ele_order where CAR_ID=#{carId} and STATUS='已支付' or CAR_ID=#{carId} and STATUS='已派单' or CAR_ID=#{carId} and STATUS='已办理' or CAR_ID=#{carId} and STATUS='已上牌'")
	public EleOrder selectOrderByCarId2(int carId);


	@Select("SELECT  SUM(fixed_price) from item i LEFT JOIN product p ON i.product_id =  p.product_id WHERE i.order_id = #{orderId} ")
	int selectOrderPrice(Integer orderId);
}
