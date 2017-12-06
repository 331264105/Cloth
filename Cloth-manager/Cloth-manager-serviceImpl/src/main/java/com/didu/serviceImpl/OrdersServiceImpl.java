package com.didu.serviceImpl;

import com.didu.dao.OrdersDao;
import com.didu.domain.Orders;
import com.didu.domain.OrdersShop;
import com.didu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public boolean addOrders(Orders orders) {
        return ordersDao.addOrders(orders)>0?true:false;
    }

    @Override
    public boolean addOrdersShop(OrdersShop ordersShop) {
        return ordersDao.addOrdersShop(ordersShop)>0?true:false;
    }

    @Override
    public Orders queryOrderById(int id) {
        return ordersDao.queryOrderById(id);
    }

    @Override
    public boolean deOrders(int id) {
        return ordersDao.deOrders(id)>0?true:false;
    }

    @Override
    public boolean deOrdersShop(String serial) {
        return ordersDao.deOrdersShop(serial)>0?true:false;
    }

    @Override
    public List<Orders> queryOrder(int pid, String status) {
        return ordersDao.queryOrder(pid,status);
    }

    @Override
    public List<OrdersShop> queryShopByOid(String serial) {
        return ordersDao.queryShopByOid(serial);
    }

    @Override
    public boolean updateOrder(Orders order) {
        return ordersDao.updateOrder(order)>0?true:false;
    }
}
