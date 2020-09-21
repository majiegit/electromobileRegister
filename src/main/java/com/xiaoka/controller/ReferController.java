package com.xiaoka.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.xiaoka.bean.EBC;
import com.xiaoka.bean.EBCOMP;
import com.xiaoka.bean.EBP;
import com.xiaoka.bean.Pops;
import com.xiaoka.service.ReferService;

@Controller
public class ReferController {

    @Autowired
    private ReferService referService;

    /**
     * 查询个人信息
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referP", method = RequestMethod.POST)
    @ResponseBody
    public EBP referP(HttpServletRequest httpServletRequest) {

        return referService.referP(httpServletRequest.getParameter("idCard"));

    }

    /**
     * 根据id查询企业信息
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referComp", method = RequestMethod.POST)
    @ResponseBody
    public EBCOMP referComp(HttpServletRequest httpServletRequest) {

        return referService.referComp(httpServletRequest.getParameter("id"));

    }

    /**
     * 查询所有车辆
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referC", method = RequestMethod.POST)
    @ResponseBody
    public List<EBC> referC(HttpServletRequest httpServletRequest) {

        return referService.referC(httpServletRequest.getParameter("idCard"));

    }

    /**
     * 查询个人车辆
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referPC", method = RequestMethod.POST)
    @ResponseBody
    public List<EBC> referPC(HttpServletRequest httpServletRequest) {

        return referService.referPC(httpServletRequest.getParameter("idCard"));

    }

    /**
     * 根据车辆id查询车辆
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referCbyCarId", method = RequestMethod.POST)
    @ResponseBody
    public List<EBC> referCbyCarId(HttpServletRequest httpServletRequest) {

        return referService.referCbyCarId(httpServletRequest.getParameter("carId"));

    }

    /**
     * 查询企业车辆
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referCC", method = RequestMethod.POST)
    @ResponseBody
    public List<EBC> referCC(HttpServletRequest httpServletRequest) {

        return referService.referCC(httpServletRequest.getParameter("belong"), httpServletRequest.getParameter("num"));

    }

    /**
     * 查询所有的运营点
     *
     * @return
     */
    @RequestMapping(value = "/referPOPS", method = RequestMethod.POST)
    @ResponseBody
    public List<Pops> referPOPS() {

        return referService.referPOPS();

    }

    /**
     * 根据popsId查询运营点
     *
     * @param httpServletRequest
     * @return
     */
    @RequestMapping(value = "/referPOPSbyId", method = RequestMethod.POST)
    @ResponseBody
    public Pops referPOPSbyId(HttpServletRequest httpServletRequest) {

        return referService.referPOPSbyId(httpServletRequest.getParameter("popsId"));

    }

    /***
     * 完善车辆用途信息
     * @return
     */
    @PostMapping("/updateCarInfo")
    @ResponseBody
    public Map<String, Object> updateCarInfo(@RequestBody List<EBC> ebcs) {
        ebcs.forEach(ebc -> referService.updateCarInfo(ebc));
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("msg", 1);
        map.put("data", "保存成功");
        return map;
    }
}
