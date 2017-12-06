package com.didu.service;

import com.didu.domain.Push;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface PushService {
    boolean addImage(Push push);
    List<Push> queryPush(Push push);
    boolean dePush(Push push);
}
