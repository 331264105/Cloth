package com.didu.sql;

import com.didu.domain.Orders;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/12/1.
 */
public class OrderSql {
    public String lookOrderByStatus(int pid,String status)
    {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("orders");
                if (pid != 0) {
                    WHERE("pid=#{arg0}");
                }
                if (status != null && status.length() > 0) {
                    WHERE("`status`=#{arg1}");
                }
            }
        }.toString();
        return  sql;
    }
    public String updateOrderStatus(Orders orders){
        String sql = new SQL() {
            {
                UPDATE("orders");
                if (orders.getStatus() != null&& orders.getStatus().length()>0) {
                    SET("`status`= #{status}");
                }
                if (orders.getBtime() != null&& orders.getBtime().length()>0) {
                    SET("btime = #{btime}");
                }
                if (orders.getCtime() != null&& orders.getCtime().length()>0) {
                    SET("ctime = #{ctime}");
                }
                WHERE("serial=#{serial}");
            }
        }.toString();
        return  sql;
    }
}
