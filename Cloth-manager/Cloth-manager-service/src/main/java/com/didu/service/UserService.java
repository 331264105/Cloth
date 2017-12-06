package com.didu.service;

import com.didu.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface UserService {
    List<User> queryUser(User user);
    boolean addUser(User user);
    boolean updateUser(User user);
}
