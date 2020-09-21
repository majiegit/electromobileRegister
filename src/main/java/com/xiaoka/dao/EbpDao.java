package com.xiaoka.dao;

import com.xiaoka.bean.EBP;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EbpDao {

    @Select("select * from eb_p where idcard = #{idCard}")
    EBP getByidCard(@Param("idCard") String idCard);


    @Update("update eb_p set USERNAME= #{userName},PHONE_NUM = #{phoneNum},SEX=#{sex}," +
            "stature_height=#{statureHeight},weight=#{weight},blood=#{blood},health_condition= #{healthCondition}," +
            "marital_status=#{maritalStatus},politics_status = #{politicsStatus}, exigency_phone= #{exigencyPhone}," +
            "census_register_address=#{censusRegisterAddress},present_address=#{presentAddress},driving_licence=#{drivingLicence}," +
            "occupation_type=#{occupationType},education_background=#{educationBackground},unit_name=#{unitName}," +
            "unit_address=#{unitAddress},vocational_skills_certificate=#{vocationalSkillsCertificate}," +
            "vocational_skills_certificate_level=#{vocationalSkillsCertificateLevel},medical_insurance=#{medicalInsurance}," +
            "endowment_insurance=#{endowmentInsurance},accumulation_fund=#{accumulationFund} where IDCARD = #{idCard}")
    int updateEbp(EBP ebp);
}
