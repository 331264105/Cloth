package com.didu.dao;

import com.didu.domain.Teamwork;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface TeamworkDao {
    //添加合作商
    @Insert("insert into teamwork(username,userphone,address,project,uid) values(#{username},#{userphone},#{address},#{project},#{uid})")
    int addTeamwork(Teamwork teamwork);
    //删除合作商
    @Delete("delete from teamwork where id =#{id}")
    int deTeamwork(Teamwork teamwork);
}
