package com.xiaoka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.xiaoka.bean.Violation;

public interface ViolationDao {
	/**
	 * 开罚单
	 * 
	 * @param violation
	 * @return
	 */
	@Insert("insert into violation(license_num,violation_date,violation_site,violation_type,violation_fine,violation_mark,violation_driver) values(#{licenseNum},#{violationDate},#{violationSite},#{violationType},#{violationFine},#{violationMark},#{violationDriver})")
	public int violationAdd(Violation violation);

	/**
	 * 查罚单
	 * 
	 * @param licenseNum
	 * @return
	 */
	@Select("select * from violation where license_num=#{licenseNum}")
	public List<Violation> violationFind(String licenseNum);

}
