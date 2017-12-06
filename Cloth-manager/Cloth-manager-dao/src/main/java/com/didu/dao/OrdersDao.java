package com.didu.dao;

import com.didu.domain.Orders;
import com.didu.domain.OrdersShop;
import com.didu.sql.OrderSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface OrdersDao {
    //添加订单
    @Insert("insert into ordersshop(serial,`name`,url,color,num,price,cid,pid,sku,units) values(#{serial},#{name},#{url},#{color},#{num},#{price},#{cid},#{pid},#{sku},#{units})")
    int addOrdersShop(OrdersShop ordersShop);
    @Insert("insert into orders(serial,pid,totalnum,sum,uname,address,`leave`,uphone,`status`,atime,btime,ctime) values(#{serial},#{pid},#{totalnum},#{sum},#{uname},#{address},#{leave},#{uphone},#{status},now(),#{btime},#{ctime})")
    int addOrders(Orders orders);

    //通过id查看订单
    @Select("select * from orders where id=#{id}")
    Orders queryOrderById(int id);

    //删除订单商品
    @Delete("delete from ordersshop where serial=#{serial}")
    int deOrdersShop(String serial);

    //后台删除订单
    @Delete("delete from orders where id=#{id}")
    int deOrders(int id);

    //查看订单里面的商品通过serial
    @Select("select * from  ordersshop where serial=#{arg0} order by id desc")
    List<OrdersShop> queryShopByOid(String serial);

    @SelectProvider(type = OrderSql.class,method ="lookOrderByStatus")
    List<Orders> queryOrder(int pid,String status);

    //后台修改订单
    @UpdateProvider(type = OrderSql.class,method = "updateOrderStatus")
    int updateOrder(Orders orders);

}
