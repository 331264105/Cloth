package com.didu.serviceImpl;

import com.didu.dao.FindversionDao;
import com.didu.domain.Findversion;
import com.didu.domain.Findversionpic;
import com.didu.service.FindversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
@Service
@Transactional
public class FindversionServiceImpl implements FindversionService {
    @Autowired
    private FindversionDao findversionDao;
    @Override
    public boolean addFindversion(Findversion findversion) {
        return findversionDao.addFindversion(findversion)>0?true:false;
    }

    @Override
    public int queryMax() {
        return findversionDao.queryMax();
    }

    @Override
    public boolean addFindversionpic(Findversionpic findversionpic) {
        return findversionDao.addFindversionpic(findversionpic)>0?true:false;
    }

    @Override
    public List<Findversionpic> queryFindversionpicByid(int uid) {
        return findversionDao.queryFindversionpicByid(uid);
    }

    @Override
    public boolean deFindversion(Findversion findversion) {
        return findversionDao.deFindversion(findversion)>0?true:false;
    }

    @Override
    public List<Findversion> queryFindversion(String status,int uid) {
        return findversionDao.queryFindversion(status,uid);
    }

    @Override
    public boolean deFindversionpic(int id) {
        return findversionDao.deFindversionpic(id)>0?true:false;
    }

    @Override
    public int queryIdByuid(int uid) {
        return findversionDao.queryIdByuid(uid);
    }
}
