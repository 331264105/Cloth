package com.didu.serviceImpl;

import com.didu.dao.ShoppingcarDao;
import com.didu.domain.Shoppingcar;
import com.didu.service.ShoppingcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
@Service
@Transactional
public class ShoppingcarServiceImpl implements ShoppingcarService{
    @Autowired
    private ShoppingcarDao shoppingcarDao;
    @Override
    public boolean addShoppingcar(Shoppingcar shoppingcar) {
        return shoppingcarDao.addShoppingcar(shoppingcar)>0?true:false;
    }

    @Override
    public boolean removeShoppingcar(int id) {
        return shoppingcarDao.removeShoppingcar(id)>0?true:false;
    }

    @Override
    public List<Shoppingcar> queryShoppingcar(int pid) {
        return shoppingcarDao.queryShoppingcar(pid);
    }
}
