package com.xiaoka.controller;

import cn.hutool.core.util.ObjectUtil;
import com.xiaoka.bean.EBP;
import com.xiaoka.service.EbpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/epb")
public class EbpController {
    @Autowired
    private EbpService ebpService;

    /**
     * 查询个人信息
     *
     * @param idCard
     * @return
     */
    @PostMapping("/get")
    public Map getByidCard(@RequestParam("idCard") String idCard) {
        EBP ebp = ebpService.getByidCard(idCard);
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if (ObjectUtil.isNotEmpty(ebp)) {
            map.put("msg", "1");
            map.put("data", ebp);
        }else {
            map.put("msg", "-1");
            map.put("data", "没有找到对应个人信息");
        }
        return map;
    }

    /**
     * 完善个人资料信息
     *
     * @param ebp
     * @return
     */
    @PostMapping("/update")
    public Map<String, Object> updateEbp(@RequestBody EBP ebp) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        try {
            int i = ebpService.updateEbp(ebp);
            if (i == 1) {
                map.put("msg", i);
                map.put("data", "保存成功");
            }
        } catch (Exception e) {
            map.put("msg", -1);
            map.put("data", "保存失败");
            e.printStackTrace();
        }
        return map;
    }
}
