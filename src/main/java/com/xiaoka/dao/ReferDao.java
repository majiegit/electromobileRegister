package com.xiaoka.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.bean.Pops;
import org.apache.ibatis.annotations.Update;

public interface ReferDao {

    /**
     * 查询个人信息
     *
     * @param idCard
     * @return
     */
    @Select("select * from eb_p where IDCARD = #{idCard}")
    public EBP referP(@Param(value = "idCard") String idCard);

    /**
     * 查询所有车辆信息
     *
     * @param idCard
     * @return
     */
    @Select("select * from eb_c where IDCARD = #{idCard}")
    public List<EBC> referC(String idCard);

    /**
     * 查询个人所有车辆信息
     *
     * @param idCard
     * @return
     */
    @Select("select * from eb_c where IDCARD = #{idCard} and IS_COMP = '否'")
    public List<EBC> referPC(String idCard);

    /**
     * 根据车辆id查询信息
     *
     * @param idCard
     * @return
     */
    @Select("select * from eb_c where CAR_ID = #{carId}")
    public List<EBC> referCbyCarId(String carId);


    /**
     * 根据车辆id查询信息2
     *
     * @param idCard
     * @return
     */
    @Select("select * from eb_c where CAR_ID = #{carId}")
    public EBC referCbyCarId2(int carId);

    /**
     * 查询企业车辆信息
     *
     * @param belong
     * @return
     */
    @Select("${str}")
    public List<EBC> referCC(@Param(value = "str") String str, @Param(value = "belong") String belong, @Param(value = "num") String num);

    /**
     * 查询所有的运营点
     *
     * @return
     */
    @Select("select * from pops")
    public List<Pops> referPOPS();

    /**
     * 根据企业id查询企业信息
     *
     * @param parseInt
     * @return
     */
    @Select("select * from ebcomp where id =#{id}")
    public EBCOMP referComp(int id);

    /**
     * 根据popsId查询运营点
     *
     * @param parameter
     * @return
     */
    @Select("select * from pops where POPS_ID=#{popsId}")
    public Pops referPOPSbyId(int popsId);

    /**
     * 完善车辆用途信息
     * @param ebc
     * @return
     */
    @Update("update eb_c set CAR_USE = #{carUse} where CAR_ID=#{carId}")
    int updateCarInfo(EBC ebc);
}
