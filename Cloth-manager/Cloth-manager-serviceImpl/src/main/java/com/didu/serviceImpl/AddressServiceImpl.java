package com.didu.serviceImpl;

import com.didu.dao.AddressDao;
import com.didu.domain.Address;
import com.didu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
    @Override
    public boolean addAddress(Address address) {
        return addressDao.addAddress(address)>0?true:false;
    }

    @Override
    public List<Address> queryAddress(Address address) {
        return addressDao.queryAddress(address);
    }

    @Override
    public boolean deAddress(int id) {
        return addressDao.deAddress(id)>0?true:false;
    }

    @Override
    public boolean updateAddress(Address address) {
        return addressDao.updateAddress(address)>0?true:false;
    }

    @Override
    public boolean updateSelected() {
        return addressDao.updateSelected()>0?true:false;
    }
}
