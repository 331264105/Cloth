package com.didu.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.didu.utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/11/23.
 */
@Controller
public class PayControl {
    //微信appid
    private static final String wx_appid="wx72344b6878aff11b";
    //商户号
    private static final String wx_mch_id="1491197502";
    //回调函数url
    private static final String wx_return_url="http://www.didu86.com/football-manager-web/ReturnResult";
    //统一下单地址
    private static final String UNIFORMORDER = "https://api.mch.weixin.qq.com/pay/unifiedorder";
    //交易类型
    private static final String TRADETYPE = "JSAPI";
    //微信key秘钥
    @RequestMapping("/payMoney")
    @ResponseBody
    public String payMoney(String openid,String wx_total_fee,String wx_body,String wx_out_trade_no,HttpServletRequest request) throws UnsupportedEncodingException {
        HashMap<Object,Object> result=new HashMap<>();
        //32位随机数
        String wx_nonce_str= payUtils.createConceStr(32);
        //服务器ip地址
        String wx_spbill_create_ip=request.getRemoteAddr();
        //签名
        String sign="";
        String paySign="";
        SortedMap<Object,Object> map = new TreeMap<Object, Object>();
        map.put("body",wx_body);
        map.put("appid",wx_appid);
        map.put("mch_id",wx_mch_id);
        map.put("nonce_str",wx_nonce_str);
        map.put("notify_url",wx_return_url);
        map.put("openid",openid);
        map.put("out_trade_no",wx_out_trade_no);
        map.put("spbill_create_ip",wx_spbill_create_ip);
        map.put("total_fee", BigDecimal.valueOf(Long.parseLong(wx_total_fee)).multiply(new BigDecimal(100)).toString());
        map.put("trade_type",TRADETYPE);
        sign= MD5Utils.createSign(map);
        map.put("sign",sign);
        String xml = CreateXmlUtils.getRequestXML(map);
        System.out.println("**********************************************************************");
        System.out.println(wx_spbill_create_ip+"<<------>>"+xml);
        System.out.println("**********************************************************************");
        String content = HttpUtil.sendPost(UNIFORMORDER, xml);
        System.err.println(content);
        JSONObject jsonObject = JSONObject.parseObject(XmltoJsonUtil.xml2JSON(content)) ;
        JSONObject result_xml = jsonObject.getJSONObject("xml");
        JSONArray result_code =  result_xml.getJSONArray("result_code");
        JSONArray prepay_id = result_xml.getJSONArray("prepay_id");
        JSONArray nonce_str2 = result_xml.getJSONArray("nonce_str");
        JSONArray returnsignl = result_xml.getJSONArray("sign");
        JSONArray appid1 = result_xml.getJSONArray("appid");
        JSONArray mch_id1 = result_xml.getJSONArray("mch_id");
        String prepayId = (String)prepay_id.get(0);
        String nonce_str = (String)nonce_str2.get(0);
        String returnsign =(String)returnsignl.get(0);
        String appid =(String)appid1.get(0);
        String mch_id =(String)mch_id1.get(0);
        String l = System.currentTimeMillis()+"";
        SortedMap<Object,Object> returnmap = new TreeMap<Object, Object>();
        returnmap.put("appId",appid);
        returnmap.put("nonceStr",nonce_str);
        returnmap.put("package=prepay_id",prepayId);
        returnmap.put("signType","MD5");
        returnmap.put("timeStamp",l);
        System.out.println("<<<-----------------------"+returnmap+"-------------------->>>");
        paySign= MD5Utils.createSign(returnmap);
        System.out.println("<<<-----------------------"+paySign+"-------------------->>>");
        String code = (String)result_code.get(0);
        HashMap<Object,Object> data=new HashMap<>();
        if(code.equalsIgnoreCase("FAIL")){
            result.put("MSG","微信统一订单下单失败");
            result.put("status", "-1");
            result.put("result", data);
        }else if(code.equalsIgnoreCase("SUCCESS")){
            data.put("prepay_id",prepayId);
            data.put("noncestr",nonce_str);
            data.put("returnsign",returnsign);
            data.put("appid",appid);
            data.put("mch_id",mch_id);
            data.put("paySign",paySign);
            data.put("timeStamp",l);
            result.put("MSG", "微信统一订单下单成功");
            result.put("status", "1");
            result.put("result", data);
        }
        System.err.println(JSON.toJSONString(result));
        return JSON.toJSONString(result);
    }
}
