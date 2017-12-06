package com.didu.serviceImpl;

import com.didu.dao.PushDao;
import com.didu.domain.Push;
import com.didu.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
@Service
@Transactional
public class PushServiceImpl implements PushService {
    @Autowired
    private PushDao pushDao;
    @Override
    public boolean addImage(Push push) {
        return pushDao.addImage(push)>0?true:false;
    }

    @Override
    public List<Push> queryPush(Push push) {
        return pushDao.queryPush(push);
    }

    @Override
    public boolean dePush(Push push) {
        return pushDao.dePush(push)>0?true:false;
    }
}
