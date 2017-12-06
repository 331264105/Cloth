package com.didu.utils;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2017/11/16.
 */
public class HttpUtilByJson {
    public static String sendPost(String url,JSON json){
        PrintWriter out = null;
        BufferedReader in = null;
        String result="";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());

            out.print(json);

            out.flush();

            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null)
            {
                //String line;
                result = result + line;
            }
        }  catch (IOException e) {
            try
            {
                if (out != null) {
                    out.close();
                }
                if (in != null)
                    in.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (out != null) {
                    out.close();
                }
                if (in != null)
                    in.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
