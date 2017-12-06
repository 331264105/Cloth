package com.didu.dao;

import com.didu.domain.User;
import com.didu.sql.UserSql;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface UserDao {
    @Insert("insert into user(userphone,openid,username) values(#{userphone},#{openid},#{username})")
    int addUser(User user);
    @UpdateProvider(type = UserSql.class,method = "updateUser")
    int updateUser(User user);
    @SelectProvider(type = UserSql.class,method = "queryUsers")
    List<User> queryUser(User user);
    @Select("select * from user where openid =#{openid}")
    List<User> queryUser1(User user);
}
