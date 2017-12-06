package com.didu.dao;

import com.didu.domain.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ItemDao {
    //添加状态
    @Insert("insert into status(status,statu) values(#{status},#{statu})")
    int addStatus(Status status);
    //删除状态
    @Delete("delete from status where id =#{id}")
    int deStatus(int id);
    //添加颜色
    @Insert("insert into color(color,statu) values(#{color},#{statu})")
    int addColor(Color status);
    //删除颜色
    @Delete("delete from color where id =#{id}")
    int deColor(int id);
    //添加品名
    @Insert("insert into productname(pname,statu) values(#{pname},#{statu})")
    int addProductname(Productname status);
    //删除品名
    @Delete("delete from productname where id =#{id}")
    int deProductname(int id);
    //添加面料
    @Insert("insert into fabricorg(fabric,statu) values(#{fabric},#{statu})")
    int addFabric(Fabricorg status);
    //删除面料
    @Delete("delete from fabricorg where id =#{id}")
    int deFabric(int id);
    //添加季节
    @Insert("insert into season(season,statu) values(#{season},#{statu})")
    int addSeason(Season status);
    //删除季节
    @Delete("delete from season where id =#{id}")
    int deSeason(int id);
    @Select("select * from status where statu=#{statu}")
    List<Status> queryStatus(String statu);
    @Select("select * from color where statu=#{statu}")
    List<Color> queryColor(String statu);
    @Select("select * from productname where statu=#{statu}")
    List<Productname> queryProductname(String statu);
    @Select("select * from fabricorg where statu=#{statu}")
    List<Fabricorg> queryFabric(String statu);
    @Select("select * from season where statu=#{statu}")
    List<Season> querySeason(String statu);
}
