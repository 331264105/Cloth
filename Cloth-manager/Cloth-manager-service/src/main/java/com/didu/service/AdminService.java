package com.didu.service;

import com.didu.domain.Admin;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface AdminService {
    boolean addAdmin(Admin admin);
    Admin queryAdmin(Admin admin);
    List<Admin> queryAdmins(Admin admin);
    boolean deAdmin(Admin admin);
    boolean updateAdmin(Admin admin);
}
