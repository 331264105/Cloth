package com.didu.sql;

import com.didu.domain.Push;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/11/28.
 */
public class PushSql {
    public String queryPush(Push carousel){
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("push");
                if (carousel.getId() > 0) {
                    WHERE("id=#{id}");
                }
            }
        }.toString();
        return sql;
    }
}
