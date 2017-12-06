package com.didu.sql;

import com.didu.domain.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/12/4.
 */
public class UserSql {
    public String queryUsers(User user) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("user");
                if (user.getOpenid()!=null && user.getOpenid().length()>0) {
                    WHERE("openid=#{openid}");
                }
            }
        }.toString();
        return sql;
    }
    public String updateUser(User user){
        String sql=new SQL(){
            {
                UPDATE("user");

                if (user.getUserphone()!=null&&user.getUserphone().length()>0){
                    SET("userphone=#{userphone}");
                }
                if (user.getUsername()!=null&&user.getUsername().length()>0){
                    SET("username=#{username}");
                }
                WHERE("openid=#{openid}");
            }
        }.toString();
        return sql;
    }
}
