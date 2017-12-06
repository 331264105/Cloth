package com.didu.sql;

import com.didu.domain.Carousel;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/11/27.
 */
public class CarouselSql {
    public String queryCarousels(Carousel carousel){
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("carousel");
                if (carousel.getId() > 0) {
                    WHERE("id=#{id}");
                }
            }
        }.toString();
        return sql;
    }
}
