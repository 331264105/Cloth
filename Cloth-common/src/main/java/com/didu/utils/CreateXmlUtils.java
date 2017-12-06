package com.didu.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by Administrator on 2017/11/14.
 */
public class CreateXmlUtils {
    //拼接xml 请求路径
    public static String getRequestXML(SortedMap<Object, Object> parame){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<xml>");
        Set set = parame.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            //过滤相关字段sign
            if("sign".equalsIgnoreCase(key)){
                buffer.append("<"+key+">"+"<![CDATA["+value+"]]>"+"</"+key+">");
            }else{
                buffer.append("<"+key+">"+value+"</"+key+">");
            }
        }
        buffer.append("</xml>");
        return buffer.toString();
    }
}
