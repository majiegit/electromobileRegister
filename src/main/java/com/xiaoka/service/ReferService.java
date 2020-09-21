package com.xiaoka.service;

import java.util.List;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.bean.Pops;
import com.xiaoka.dao.ReferDao;

@Service
public class ReferService {
	@Autowired
	private ReferDao referDao;

	/**
	 * 查询个人信息
	 * 
	 * @param idCard
	 * @return
	 */
	public EBP referP(String idCard) {

		return referDao.referP(idCard);

	}

	/**
	 * 查询所有车辆信息
	 * 
	 * @param idCard
	 * @return
	 */
	public List<EBC> referC(String idCard) {
		return referDao.referC(idCard);
	}

	/**
	 * 查询个人车辆信息
	 * 
	 * @param idCard
	 * @return
	 */
	public List<EBC> referPC(String idCard) {
		return referDao.referPC(idCard);
	}

	/**
	 * 根据车辆id查询车辆
	 * 
	 * @param parameter
	 * @return
	 */
	public List<EBC> referCbyCarId(String carId) {
		return referDao.referCbyCarId(carId);
	}

	/**
	 * 查询企业车辆信息
	 * 
	 * @param idCard
	 * @return
	 */
	public List<EBC> referCC(String belong,String num) {
		String str = new SQL() {
			{
				SELECT("*");			
				FROM("eb_c");
				WHERE("BELONG = #{belong} and CAR_BODY_NUM = #{num} or BELONG = #{belong} and CAR_ELE_NUM=#{num}");
			}
		}.toString();
		return referDao.referCC(str,belong,num);
	}

	/**
	 * 查询所有的运营点
	 * 
	 * @return
	 */
	public List<Pops> referPOPS() {
		return referDao.referPOPS();

	}

	/**
	 * 根据企业id查询企业信息
	 * 
	 * @param parameter
	 * @return
	 */
	public EBCOMP referComp(String id) {

		return referDao.referComp(Integer.parseInt(id));
	}

	/**
	 * 根据popsId查询运营点
	 * 
	 * @param parameter
	 * @return
	 */
	public Pops referPOPSbyId(String parameter) {
		return referDao.referPOPSbyId(Integer.parseInt(parameter));		 
	}

	/**
	 * 完善车辆用途信息
	 * @param ebc
	 * @return
	 */
	public int updateCarInfo(EBC ebc) {
		return referDao.updateCarInfo(ebc);
	}
}
