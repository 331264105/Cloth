package com.didu.utils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 * Created by Administrator on 2017/11/14.
 */
public class MD5Utils {
    //创建md5 数字签证
    public static String createSign(SortedMap<Object, Object> parame){
        StringBuffer buffer = new StringBuffer();
        Set set = parame.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String)entry.getKey();
            Object value = (String)entry.getValue();
            if(null != value && !"".equals(value) && !"sign".equals(key) && !"key".equals(key)){
                buffer.append(key+"="+value+"&");
            }
        }
        buffer.append("key="+"hzyzsjyzxyxgs1234567891234567890");
        String sign =MyMd5Util.md5(buffer.toString()).toUpperCase();
        System.out.println("签名参数："+sign);
        return sign;
    }
}
