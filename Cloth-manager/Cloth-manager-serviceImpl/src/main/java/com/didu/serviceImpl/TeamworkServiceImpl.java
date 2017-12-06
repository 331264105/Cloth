package com.didu.serviceImpl;

import com.didu.dao.TeamworkDao;
import com.didu.domain.Teamwork;
import com.didu.service.TeamworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/12/4.
 */
@Service
@Transactional
public class TeamworkServiceImpl implements TeamworkService {
    @Autowired
    private TeamworkDao teamworkDao;
    @Override
    public boolean addTeamwork(Teamwork teamwork) {
        return teamworkDao.addTeamwork(teamwork)>0?true:false;
    }

    @Override
    public boolean deTeamwork(Teamwork teamwork) {
        return teamworkDao.deTeamwork(teamwork)>0?true:false;
    }
}
