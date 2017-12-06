package com.didu.sql;

import com.didu.domain.Product;
import com.didu.utils.Page;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by Administrator on 2017/11/29.
 */
public class ProductSql {
    public String queryProduct(Product carousel,Page page){
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("product");
                if (carousel.getId() > 0) {
                    WHERE("id=#{arg0.id}");
                }
                if(carousel.getName()!=null&&carousel.getName().length()>0){
                    WHERE("name like CONCAT('%',#{arg0.name},'%')");
                }
                if(carousel.getColor()!=null&&carousel.getColor().length()>0){
                    WHERE("color=#{arg0.color}");
                }
                if(carousel.getSeason()!=null&&carousel.getSeason().length()>0){
                    WHERE("season=#{argo.season}");
                }
                if(carousel.getStatus()!=null&&carousel.getStatus().length()>0){
                    WHERE("status=#{arg0.status}");
                }

                if(carousel.getFabric()!=null&&carousel.getFabric().length()>0){
                    WHERE("fabric=#{arg0.fabric}");
                }
                if(carousel.getArt()!=null&&carousel.getArt().length()>0){
                    WHERE("art=#{arg0.art}");
                }
                if(carousel.getStatu()!=null&&carousel.getStatu().length()>0){
                    WHERE("statu=#{arg0.statu}");
                }
                if(carousel.getNum()>0){
                    WHERE("num=#{arg0.num}");
                }
                if(carousel.getPlace()!=null&&carousel.getPlace().length()>0){
                    WHERE("place=#{arg0.place}");
                }
                if(carousel.getPname()!=null&&carousel.getPname().length()>0){
                    WHERE("pname=#{arg0.pname}");
                }
                if(carousel.getTextture()!=null&&carousel.getTextture().length()>0){
                    WHERE("textture=#{arg0.textture}");
                }
                ORDER_BY("id desc");
            }
        }.toString();
        sql+=" limit #{arg1.page},#{arg1.rows}";
        return sql;
    }
}
