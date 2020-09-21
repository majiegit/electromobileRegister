package com.xiaoka.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;

public interface LoginDao {
	/**
	 * 个人登陆
	 * @param userName
	 * @param idCard
	 * @return EBP
	 */
	@Select("select * from eb_p where USERNAME = #{userName} and IDCARD = #{idCard}")
	public EBP Plogin(@Param(value = "userName") String userName ,@Param(value = "idCard")String idCard);

	/**
	 * 企业登陆
	 * @param count
	 * @param password
	 * @return
	 */
	@Select("select * from ebcomp where COUNT = #{count} and PASSWORD = #{password}")
	public EBCOMP compLogin(@Param(value = "count")String count,@Param(value = "password") String password);

}
