package com.didu.web;

import com.didu.domain.*;
import com.didu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
public class ItemControl {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/addStatus")
    @ResponseBody
    public boolean addStatus(Status status){
        boolean b = itemService.addStatus(status);
        return b;
    }
    @RequestMapping("/deStatus")
    @ResponseBody
    public boolean deStatus(int id){
        return itemService.deStatus(id);
    }
    @RequestMapping("/addColor")
    @ResponseBody
    public boolean addColor(Color status){
        boolean b = itemService.addColor(status);
        return b;
    }
    @RequestMapping("/deColor")
    @ResponseBody
    public boolean deColor(int id){
        return itemService.deColor(id);
    }
    @RequestMapping("/addProductname")
    @ResponseBody
    public boolean addProductname(Productname productname){
        boolean b = itemService.addProductname(productname);
        return b;
    }
    @RequestMapping("/deProductname")
    @ResponseBody
    public boolean deProductname(int id){
        return itemService.deProductname(id);
    }
    @RequestMapping("/addFabric")
    @ResponseBody
    public boolean addFabric(Fabricorg fabricorg){
        boolean b = itemService.addFabric(fabricorg);
        return b;
    }
    @RequestMapping("/deFabric")
    @ResponseBody
    public boolean deFabric(int id){
        return itemService.deFabric(id);
    }
    @RequestMapping("/addSeason")
    @ResponseBody
    public boolean addSeason(Season season){
        boolean b = itemService.addSeason(season);
        return b;
    }
    @RequestMapping("/deSeason")
    @ResponseBody
    public boolean deSeason(int id){
        return itemService.deSeason(id);
    }
    @RequestMapping("/queryItem")
    @ResponseBody
    public List<List<?>> queryItem(String statu){
        ArrayList<List<?>> list = new ArrayList<>();
        List<Status> statuses = itemService.queryStatus(statu);
        List<Color> colors = itemService.queryColor(statu);
        List<Productname> productnames = itemService.queryProductname(statu);
        List<Fabricorg> fabricorgs = itemService.queryFabric(statu);
        List<Season> seasons = itemService.querySeason(statu);
        list.add(statuses);
        list.add(colors);
        list.add(productnames);
        list.add(fabricorgs);
        list.add(seasons);
        return list;
    }
}
