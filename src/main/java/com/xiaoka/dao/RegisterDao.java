package com.xiaoka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;

public interface RegisterDao {
	/**
	 * 查询所有个人信息
	 * 
	 * @return
	 */
	@Select("select * from eb_p")
	public List<EBP> getAll();

	/**
	 * 添加个人信息
	 * 
	 * @param ebp
	 * @return int
	 */
	@Insert("insert into eb_p(USERNAME,PHONE_NUM,IDCARD,PROVINCE,CITY,AREA,STREET,ADDRESS,SEX) values(#{userName},#{phoneNum},#{idCard},#{province},#{city},#{area},#{street},#{address},#{sex})")
	public int regist(EBP ebp);

	/**
	 * 查询身份证是否被注册
	 * 
	 * @param idCard
	 * @return EBP
	 */
	@Select("select * from eb_p where IDCARD = #{idCard}")
	public EBP selectIdCard(String idCard);

	/**
	 * 查询车辆信息身份证使用程度
	 * 
	 * @param idCard
	 * @return int
	 */
	@Select("select count(*) from eb_c where IDCARD=#{idCard}")
	public int selectCarIdCard(String idCard);

	/**
	 * 查询同品牌车架号使用程度
	 * 
	 * @param idCard
	 * @return
	 */
	@Select("select count(*) from eb_c where BRAND=#{brand} and CAR_BODY_NUM=#{carBodyNum}")
	public int selectCarBodyNum(@Param(value = "brand") String brand, @Param(value = "carBodyNum") String carBodyNum);

	/**
	 * 查询同品牌电机号号使用程度
	 * 
	 * @param idCard
	 * @return
	 */
	@Select("select count(*) from eb_c where BRAND=#{brand} and CAR_ELE_NUM=#{carEleNum}")
	public int selectCarEleNum(@Param(value = "brand") String brand, @Param(value = "carEleNum") String carEleNum);

	/**
	 * 添加车辆信息
	 * 
	 * @param ebc
	 * @return int
	 */
	@Insert("insert into eb_c(IDCARD,CAR_TYPE,CAR_BODY_NUM,CAR_ELE_NUM,BRAND,COLOR,BUY_DATE,IS_COMP) values(#{idCard},#{carType},#{carBodyNum},#{carEleNum},#{brand},#{color},#{buyDate},#{isComp})")
	public int registCar(EBC ebc);


	

	/**
	 * 添加企业车辆信息
	 * 
	 * @param ebc
	 * @return int
	 */
	@Insert("insert into eb_c(IDCARD,CAR_TYPE,CAR_BODY_NUM,CAR_ELE_NUM,BRAND,COLOR,BUY_DATE,IS_COMP,BELONG) values(#{idCard},#{carType},#{carBodyNum},#{carEleNum},#{brand},#{color},#{buyDate},#{isComp},#{belong})")
	public int registCompCar(EBC ebc);

	/**
	 * 添加返回车辆id
	 * 
	 * @param ebc
	 * @return
	 */
	@Select("select CAR_ID from eb_c where  CAR_BODY_NUM=#{carBodyNum} and CAR_ELE_NUM=#{carEleNum} and BRAND=#{brand}")
	public int selectCarid(EBC ebc);

}
