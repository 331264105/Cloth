package com.didu.serviceImpl;

import com.didu.dao.ItemDao;
import com.didu.domain.*;
import com.didu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Override
    public boolean addStatus(Status item) {
        return itemDao.addStatus(item)>0?true:false;
    }

    @Override
    public boolean deStatus(int id) {
        return itemDao.deStatus(id)>0?true:false;
    }

    @Override
    public boolean addColor(Color status) {
        return itemDao.addColor(status)>0?true:false;
    }

    @Override
    public boolean deColor(int id) {
        return itemDao.deColor(id)>0?true:false;
    }

    @Override
    public boolean addProductname(Productname status) {
        return itemDao.addProductname(status)>0?true:false;
    }

    @Override
    public boolean deProductname(int id) {
        return itemDao.deProductname(id)>0?true:false;
    }

    @Override
    public boolean addFabric(Fabricorg status) {
        return itemDao.addFabric(status)>0?true:false;
    }

    @Override
    public boolean deFabric(int id) {
        return itemDao.deFabric(id)>0?true:false;
    }

    @Override
    public boolean addSeason(Season status) {
        return itemDao.addSeason(status)>0?true:false;
    }

    @Override
    public boolean deSeason(int id) {
        return itemDao.deSeason(id)>0?true:false;
    }

    @Override
    public List<Status> queryStatus(String statu) {
        return itemDao.queryStatus(statu);
    }

    @Override
    public List<Color> queryColor(String statu) {
        return itemDao.queryColor(statu);
    }

    @Override
    public List<Productname> queryProductname(String statu) {
        return itemDao.queryProductname(statu);
    }

    @Override
    public List<Fabricorg> queryFabric(String statu) {
        return itemDao.queryFabric(statu);
    }

    @Override
    public List<Season> querySeason(String statu) {
        return itemDao.querySeason(statu);
    }
}
