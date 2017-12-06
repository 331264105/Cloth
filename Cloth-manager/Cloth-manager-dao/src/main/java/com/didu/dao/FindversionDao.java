package com.didu.dao;

import com.didu.domain.Findversion;
import com.didu.domain.Findversionpic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */
public interface FindversionDao {
    @Insert("insert into findversion(username,`leave`,num,price,typ,element,address,phone,`status`,uid,`datetime`,serial) values(#{username},#{leave},#{num},#{price},#{typ},#{element},#{address},#{phone},#{status},#{uid},now(),#{serial})")
    int addFindversion(Findversion findversion);
    @Select("select max(id) from findversion")
    int queryMax();
    @Insert("insert into findversionpic(url,uid,cid) values (#{url},#{uid},#{cid})")
    int addFindversionpic(Findversionpic findversionpic);
    @Select("select * from findversionpic where cid=#{id}")
    List<Findversionpic> queryFindversionpicByid(int id);
    @Delete("delete from findversion where id=#{id}")
    int deFindversion(Findversion findversion);
    @Select("select * from findversion where uid =#{arg1} and status=#{arg0}")
    List<Findversion> queryFindversion(String status,int uid);
    @Delete("delete from findversionpic where id=#{id}")
    int deFindversionpic(int id);
    @Select("select max(id) from findversion where uid = #{uid}")
    int queryIdByuid(int uid);
}
