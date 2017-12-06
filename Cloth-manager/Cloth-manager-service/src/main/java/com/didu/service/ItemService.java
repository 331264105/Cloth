package com.didu.service;

import com.didu.domain.*;

import java.util.List;


/**
 * Created by Administrator on 2017/11/29.
 */
public interface ItemService {
    boolean addStatus(Status status);
    boolean deStatus(int id);
    boolean addColor(Color status);
    boolean deColor(int id);
    boolean addProductname(Productname status);
    boolean deProductname(int id);
    boolean addFabric(Fabricorg status);
    boolean deFabric(int id);
    boolean addSeason(Season status);
    boolean deSeason(int id);
    List<Status> queryStatus(String statu);
    List<Color> queryColor(String statu);
    List<Productname> queryProductname(String statu);
    List<Fabricorg> queryFabric(String statu);
    List<Season> querySeason(String statu);
}
