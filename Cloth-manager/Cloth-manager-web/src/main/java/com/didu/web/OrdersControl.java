package com.didu.web;

import com.didu.domain.Orders;
import com.didu.domain.OrdersShop;
import com.didu.service.OrdersService;
import com.didu.service.ShoppingcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Controller
public class OrdersControl {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private ShoppingcarService shoppingcarService;
    //生成订单
    @RequestMapping("/addOrders")
    @ResponseBody
    public HashMap<String,Object> addOrders(@RequestBody Orders orders) throws IOException {
        System.err.println(orders+"00000000000000*");
        HashMap<String,Object> map = new HashMap<>();
        String s = createSerial();
        /*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        orders.setAtime(df.format(new Date()));// new Date()为获取当前系统时间
        System.err.print(orders+"0.0.0.0.0");*/
        synchronized(this.getClass()){
            orders.setSerial(s);
        }
        List<OrdersShop> ordersShopList = orders.getOrdersShopList();
        String serial = orders.getSerial();
        boolean b =false;
        boolean b1 =false;
        boolean ab =false;
        int b2=4;
        for (OrdersShop osl:ordersShopList){
            osl.setSerial(serial);
            int id = osl.getCid();
            osl.setCid(id);
            if (id!=0) {
                shoppingcarService.removeShoppingcar(id);
            }
            b = ordersService.addOrdersShop(osl);
            b2 = osl.getPid();
        }
        if (b){
            orders.setPid(b2);
            System.err.println("<<<-------------"+orders+"----------->>>");
            ab = ordersService.addOrders(orders);
            if (ab){
                map.put("serial",s);
                map.put("success","true");
                return map;
            }else{
                map.put("serial","");
                map.put("success","false");
                return map;
            }
        }
        map.put("serial","");
        map.put("success","false");
        return map;
    }
    public synchronized String createSerial() {
        String s = "SZQZ" + System.currentTimeMillis();return s;
    }
    //后台删除订单
    @RequestMapping("/removeOrders")
    @ResponseBody
    public boolean removeOrders(int id)throws IOException{
        Orders orders = ordersService.queryOrderById(id);
        String serial = orders.getSerial();
        boolean a = ordersService.deOrdersShop(serial);
        if (a){
            boolean b = ordersService.deOrders(id);
            if (b){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //查看状态订单
    @RequestMapping("/queryOrders")
    @ResponseBody
    public List<Orders> queryOrders(int pid,String status){
        if (status.equals("0")){
            status=null;
        }
        List<Orders> orderses = ordersService.queryOrder(pid,status);
        for (Orders o:orderses){
            List<OrdersShop> ordersShop = ordersService.queryShopByOid(o.getSerial());
            o.setOrdersShopList(ordersShop);
        }
        return orderses;
    }
    //查看全部订单
    @RequestMapping("/queryAllOrders")
    @ResponseBody
    public ArrayList<List<Orders>> queryAllOrders(int pid){
        ArrayList<String> l =new ArrayList();
        ArrayList<List<Orders>> Ll=new ArrayList<>();
        l.add("1");
        l.add("2");
        l.add("3");
        l.add("4");
        for (int i=0; i<l.size();i++){
            List<Orders> orderses = ordersService.queryOrder(pid, l.get(i));
            for (Orders o:orderses){
                if (o!=null) {
                    String serial = o.getSerial();
                    List<OrdersShop> ordersShops = ordersService.queryShopByOid(serial);
                    o.setOrdersShopList(ordersShops);
                }else{
                    continue;
                }
            }
            Ll.add(orderses);
        }
        return Ll;
    }
    //修改订单状态
    @RequestMapping("updateOrders")
    @ResponseBody
    public String updateOrder(Orders order){
        String status = order.getStatus();
        if (status.equals("3"))
        {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(currentTime);
            order.setCtime(dateString);
            if(ordersService.updateOrder(order)){
                return "true";
            }else{
                return "false";
            }
        }else{
            boolean b = ordersService.updateOrder(order);
            if (b){
                return "true";
            }else {
                return "false";
            }
        }
    }
}
