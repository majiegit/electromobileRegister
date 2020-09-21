package com.xiaoka.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.xiaoka.bean.CarInfo;
import com.xiaoka.bean.IdCardInfo;

public interface FileDao {
	/**
	 * 上传身份证正面信息
	 * 
	 * @param idCardInfo
	 * @return
	 */
	@Insert("insert into idcard_info(IDCARD,IDCARD_PROS,IS_PRINCIPAL,COMP_NAME) values(#{idcard},#{idcardPros},#{isPrincipal},#{compName})")
	public int idcardPicPROS(IdCardInfo idCardInfo);

	/**
	 * 个人上传身份证背面信息
	 * 
	 * @param idCardInfo
	 * @return
	 */
	@Update("update idcard_info set IDCARD_CONS=#{idcardCons} where IDCARD=#{IdCard} and IS_PRINCIPAL=#{isPrincipal}")
	public int idcardPicCons(@Param(value = "idcardCons") String idcardCons, @Param(value = "IdCard") String IdCard,
			@Param(value = "isPrincipal") String isPrincipal);

	/**
	 * 企业上传身份证背面信息
	 * 
	 * @param idcardCons
	 * @param IdCard
	 * @param isPrincipal
	 * @return
	 */
	@Update("update idcard_info set IDCARD_CONS=#{idcardCons} where IDCARD=#{IdCard} and COMP_NAME=#{compName}")
	public int idcardPicCOMPCons(@Param(value = "idcardCons") String idcardCons, @Param(value = "IdCard") String IdCard,
			@Param(value = "compName") String compName);

	/**
	 * 车辆上传前45
	 * 
	 * @param idCardInfo
	 * @return
	 */
	@Insert("insert into car_info(CAR_ID,CAR_P1,IS_COMP,COMP_NAME) values(#{carId},#{carP1},#{isComp},#{compName})")
	public int idcardPicCarPROS(CarInfo carInfo);

	/**
	 * 车辆上传后45
	 * 
	 * @param idCardInfo
	 * @return
	 */
	@Update("update car_info set CAR_P2=#{carP2} where CAR_ID=#{carId} ")
	public int idcardPicCarCONS(@Param(value = "carP2") String carP2, @Param(value = "carId") int carId);

	/**
	 * 车辆发票
	 * 
	 */
	@Update("update car_info set CAR_P3=#{carP3} where CAR_ID=#{carId} ")
	public int uploadPicCarP3(@Param(value = "carP3") String carP3, @Param(value = "carId") int carId);
	
	/**
	 * 脚踏处
	 * @param fileName
	 * @param parseInt
	 * @return
	 */
	@Update("update car_info set CAR_P4=#{carP4} where CAR_ID=#{carId} ")
	public int uploadPicCarP4(@Param(value = "carP4") String carP4, @Param(value = "carId") int carId);
	
	/**
	 * 
	 * @param fileName
	 * @param parseInt
	 * @return
	 */
	@Update("update car_info set CAR_P5=#{carP5} where CAR_ID=#{carId} ")
	public int uploadPicCarP5(@Param(value = "carP5") String carP5, @Param(value = "carId") int carId);

}
