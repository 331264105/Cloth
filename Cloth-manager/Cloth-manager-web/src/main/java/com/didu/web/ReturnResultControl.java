package com.didu.web;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.didu.utils.XmltoJsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/14.
 */
@Controller
public class ReturnResultControl {
    @RequestMapping("/ReturnResult")
    @ResponseBody
    public String ReturnResult(HttpServletRequest request,HttpServletResponse response){
        Map<Object,Object> result=new HashMap<>();
        try{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            InputStream in=request.getInputStream();
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            byte[] buffer =new byte[1024];
            int len=0;
            while((len=in.read(buffer))!=-1){
                out.write(buffer, 0, len);
            }
            out.close();
            in.close();
            String content=new String(out.toByteArray(),"utf-8");//xml数据

            JSONObject jsonObject = JSONObject.parseObject(XmltoJsonUtil.xml2JSON(content)) ;
            JSONObject result_xml = jsonObject.getJSONObject("xml");
            JSONArray result_code =  result_xml.getJSONArray("result_code");
            String code = (String)result_code.get(0);

            if(code.equalsIgnoreCase("FAIL")){
                result.put("MSG","微信统一订单下单失败");
                result.put("status","-1");

                response.getWriter().write(setXml("SUCCESS", "OK"));


            }else if(code.equalsIgnoreCase("SUCCESS")){
                result.put("MSG","微信统一订单下单成功");
                result.put("status","1");

                JSONArray out_trade_no = result_xml.getJSONArray("out_trade_no");//订单编号
                Map<String,Object> map = new HashMap<String,Object>();
                map.put("orderNum", (String)out_trade_no.get(0));
                map.put("consumState", 1);
//                accountWalletService.updateAccountOrderState(map);

                response.getWriter().write(setXml("SUCCESS", "OK"));

            }


        }catch(Exception e){
            result.put("MSG",e.getMessage());
            result.put("status","-1");
            return null;
        }
        return null;
    }
    public static String setXml(String return_code,String return_msg){
        return "<xml><return_code><![CDATA["+return_code+"]]></return_code><return_msg><![CDATA["+return_msg+"]]></return_msg></xml>";
    }
}
