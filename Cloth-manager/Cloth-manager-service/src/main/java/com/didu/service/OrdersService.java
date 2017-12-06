package com.didu.service;

import com.didu.domain.Orders;
import com.didu.domain.OrdersShop;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface OrdersService {
    boolean addOrders(Orders orders);
    boolean addOrdersShop(OrdersShop ordersShop);
    Orders queryOrderById(int id);
    boolean deOrders(int id);
    boolean deOrdersShop(String serial);

    List<Orders> queryOrder(int pid,String status);
    List<OrdersShop> queryShopByOid(String serial);
    boolean updateOrder(Orders order);
}
