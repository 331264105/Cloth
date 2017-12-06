package com.didu.service;

import com.didu.domain.Shoppingcar;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface ShoppingcarService {
    boolean addShoppingcar(Shoppingcar shoppingcar);
    boolean removeShoppingcar(int id);
    List<Shoppingcar> queryShoppingcar(int pid);
}
