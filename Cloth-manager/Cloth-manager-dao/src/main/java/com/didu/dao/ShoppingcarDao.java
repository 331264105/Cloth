package com.didu.dao;

import com.didu.domain.Shoppingcar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface ShoppingcarDao {
    //添加购物车
    @Insert("insert into shoppingcar(cid,pid,num,color,selected,name,url,price,units,sku) values (#{cid},#{pid},#{num},#{color},#{selected},#{name},#{url},#{price},#{units},#{sku})")
    int addShoppingcar(Shoppingcar shoppingcar);
    //删除购物车
    @Delete("delete from shoppingcar where id =#{id}")
    int removeShoppingcar(int id);
    //查看购物车商品
    @Select("select * from shoppingcar where pid=#{pid} order by id desc")
    List<Shoppingcar> queryShoppingcar(int pid);
}
