package com.didu.sql;

import com.didu.domain.Address;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/11/27.
 */
public class AddressSql {
    public String updateAddress(Address address)
    {
        String sql = new SQL() {{
            UPDATE("address");
            if (address.getCity() != null) {
                SET("city = #{city}");
            }if (address.getDetailaddress() != null) {
                SET("detailaddress = #{detailaddress}");
            }if (address.getPhone() != null) {
                SET("phone = #{phone}");
            }if (address.getUsername() != null) {
                SET("username = #{username}");
            }
            if (address.getSelected() != null) {
                SET("selected = #{selected}");
            }
            WHERE("id = #{id}");
        }}.toString();
        return  sql;
    }
    public String queryAddress(Address address){
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("address");
                if (address.getSelected() != null && address.getSelected().length() > 0) {
                    WHERE("selected=#{selected}");
                }
                if (address.getPid()!=0){
                    WHERE("pid=#{pid}");
                }
                if (address.getId()!=0){
                    WHERE("id=#{id}");
                }
            }
        }.toString();
        return sql;
    }
}
