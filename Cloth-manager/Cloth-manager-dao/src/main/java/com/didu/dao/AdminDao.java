package com.didu.dao;

import com.didu.domain.Admin;
import com.didu.sql.AdminSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public interface AdminDao {
    @Insert("insert into admin(password,userphone,remark,number) values(#{password},#{userphone},#{remark},#{number})")
    int addAdmin(Admin admin);
    @Select("select * from admin where userphone=#{userphone} and password=#{password}")
    Admin queryAdmin(Admin admin);
    @SelectProvider(type = AdminSql.class,method = "queryAdmin")
    List<Admin> queryAdmins(Admin admin);
    @Delete("delete from admin where id=#{id}")
    int deAdmin(Admin admin);
    @UpdateProvider(type = AdminSql.class,method = "updateAdmin")
    int updateAdmin(Admin admin);
}
