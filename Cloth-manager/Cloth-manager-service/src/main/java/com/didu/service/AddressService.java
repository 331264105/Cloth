package com.didu.service;

import com.didu.domain.Address;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface AddressService {
    boolean addAddress(Address address);
    List<Address> queryAddress(Address address);
    boolean deAddress(int id);
    boolean updateAddress(Address address);
    boolean updateSelected();
}
