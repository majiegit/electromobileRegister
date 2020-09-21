package com.xiaoka.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.xiaoka.service.OrderService;
import com.xiaoka.util.PayUtil;
import com.xiaoka.util.WechatConfig;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoka.bean.CallBackMsg;
import com.xiaoka.service.PayService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

@Controller
public class PayController {
    @Autowired
    private PayService payService;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public CallBackMsg pay(@RequestParam(value = "orderId") String orderId) {
        return payService.pay(orderId);
    }

    /**
     * 支付接口
     *
     * @param code
     * @param orderId
     * @param request
     * @return
     */
    @RequestMapping(value = "/wxPay", method = RequestMethod.POST)
    @ResponseBody
    public String wxPay(@RequestParam("code") String code, @RequestParam("orderId") Integer orderId, HttpServletRequest request) {
        Object result = new Object();
        try {
            String spbill_create_ip = getIpAddr(request);
            //将支付业务下沉到service层
            result = payService.wxPay(spbill_create_ip, code, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSONUtil.toJsonStr(result);
    }

    //这里是支付回调接口，微信支付成功后会自动调用
    @RequestMapping(value = "/wxNotify", method = RequestMethod.POST)
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line = null;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        //sb为微信返回的xml
        String notityXml = sb.toString();
        String resXml = "";
        System.out.print("回调数据：---" + notityXml);
        Map map = PayUtil.doXMLParse(notityXml);

        String returnCode = (String) map.get("return_code");
        String out_trade_no = (String) map.get("out_trade_no");
        if ("SUCCESS".equals(returnCode)) {
            //验证签名是否正确
            Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
            String prestr = PayUtil.createLinkString(validParams);
            //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
            if (PayUtil.verify(prestr, (String) map.get("sign"), WechatConfig.key, "utf-8")) {
                /**此处添加自己的业务逻辑代码start**/
                payService.pay(out_trade_no);
                /**此处添加自己的业务逻辑代码end**/
                //通知微信服务器已经支付成功
                resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                        + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
            }
        } else {
            resXml = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>"
                    + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }

        BufferedOutputStream out = new BufferedOutputStream(
                response.getOutputStream());
        out.write(resXml.getBytes());
        out.flush();
        out.close();
    }

    //获取IP
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StrUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (StrUtil.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }
        return request.getRemoteAddr();
    }
}
