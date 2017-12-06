package com.didu.web;

import com.didu.domain.Shoppingcar;
import com.didu.service.ShoppingcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Controller
public class ShoppingcarControl {
    @Autowired
    private ShoppingcarService shoppingcarService;
    @RequestMapping(value = "/addShoppingcar",method = {RequestMethod.POST})
    @ResponseBody
    public boolean addShoppingcar(@RequestBody List<Shoppingcar> shoppingcars){
        boolean ab =false;
        for (Shoppingcar sc:shoppingcars){
            sc.setSelected("true");
            ab = shoppingcarService.addShoppingcar(sc);
        }
        if (ab){
            return true;
        }else{
            return false;
        }
    }
    //删除购物车物品
    @RequestMapping("/removeShoppingcar")
    @ResponseBody
    public boolean removeShoppingcar(int id) {
        boolean s = shoppingcarService.removeShoppingcar(id);
        if (s){
            return true;
        }
        return false;
    }
    //查看购物车商品
    @RequestMapping("/queryShoppingcar")
    @ResponseBody
    public List<Shoppingcar> queryShoppingcar(int pid){
        List<Shoppingcar> shoppingcars = shoppingcarService.queryShoppingcar(pid);
        return shoppingcars;
    }
}
