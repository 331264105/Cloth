package com.didu.sql;

import com.didu.domain.Admin;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/12/4.
 */
public class AdminSql {
    public String queryAdmin(Admin admin) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("admin");
                if (admin.getUserphone()!=null&&admin.getUserphone().length()>0) {
                    WHERE("userphone=#{userphone}");
                }
                if (admin.getNumber()!=null&&admin.getNumber().length()>0) {
                    WHERE("number=#{number}");
                }
            }
        }.toString();
        return sql;
    }
    public String updateAdmin(Admin admin) {
        String sql = new SQL() {
            {
                UPDATE("admin");
                if (admin.getUserphone()!=null&&admin.getUserphone().length()>0) {
                    SET("userphone=#{userphone}");
                }
                if (admin.getPassword()!=null&&admin.getPassword().length()>0) {
                    SET("password=#{password}");
                }
                if (admin.getNumber()!=null&&admin.getNumber().length()>0) {
                    SET("number=#{number}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
        return sql;
    }
}
