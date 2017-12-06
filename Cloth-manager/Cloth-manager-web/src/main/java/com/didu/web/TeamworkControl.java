package com.didu.web;

import com.didu.domain.Teamwork;
import com.didu.service.TeamworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/12/4.
 */
@Controller
public class TeamworkControl {
    @Autowired
    private TeamworkService teamworkService;
    @RequestMapping("/addTeamwork")
    @ResponseBody
    public boolean addTeamwork(Teamwork teamwork){
        boolean a = teamworkService.addTeamwork(teamwork);
        return a;
    }
    @RequestMapping("/deTeamwork")
    @ResponseBody
    public boolean deTeamwork(Teamwork teamwork){
        boolean a = teamworkService.deTeamwork(teamwork);
        return a;
    }
}
