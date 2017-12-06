package com.didu.service;

import com.didu.domain.Findversion;
import com.didu.domain.Findversionpic;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
public interface FindversionService {
    boolean addFindversion(Findversion findversion);
    int queryMax();
    boolean addFindversionpic(Findversionpic findversionpic);
    List<Findversionpic> queryFindversionpicByid(int uid);
    boolean deFindversion(Findversion findversion);
    List<Findversion> queryFindversion(String status,int uid);
    boolean deFindversionpic(int id);
    int queryIdByuid(int uid);
}
