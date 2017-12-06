package com.didu.serviceImpl;

import com.didu.dao.UserDao;
import com.didu.domain.User;
import com.didu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> queryUser(User user) {
        return userDao.queryUser(user);
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user)>0?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user)>0?true:false;
    }
}
