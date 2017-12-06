package com.didu.serviceImpl;

import com.didu.dao.AdminDao;
import com.didu.domain.Admin;
import com.didu.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public boolean addAdmin(Admin admin) {
        return adminDao.addAdmin(admin)>0?true:false;
    }

    @Override
    public Admin queryAdmin(Admin admin) {
        return adminDao.queryAdmin(admin);
    }

    @Override
    public List<Admin> queryAdmins(Admin admin) {
        return adminDao.queryAdmins(admin);
    }

    @Override
    public boolean deAdmin(Admin admin) {
        return adminDao.deAdmin(admin)>0?true:false;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin)>0?true:false;
    }
}
