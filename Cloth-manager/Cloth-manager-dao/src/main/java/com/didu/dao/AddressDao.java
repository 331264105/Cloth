package com.didu.dao;

import com.didu.domain.Address;
import com.didu.sql.AddressSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface AddressDao {
    //添加地址
    @Insert("insert into address(username,detailaddress,city,phone,pid,selected) values(#{username},#{detailaddress},#{city},#{phone},#{pid},#{selected})")
    int addAddress(Address address);
    //查看所有地址
    @SelectProvider(type = AddressSql.class,method = "queryAddress")
    /*@Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="name",column="name"),
            @Result(property="city",column="city"),
            @Result(property="detailaddress",column="detailaddress"),
            @Result(property="phone",column="phone"),
            @Result(property="pid",column="pid"),
            @Result(property="selected",column="selected"),
    })*/
    List<Address> queryAddress(Address address);
    //删除地址
    @Delete("delete from address where id =#{id}")
    int deAddress(int id);
    //修改地址
    @UpdateProvider(type =AddressSql.class,method ="updateAddress")
    int updateAddress(Address address);
    @Update("update address set selected=''")
    int updateSelected();
}
