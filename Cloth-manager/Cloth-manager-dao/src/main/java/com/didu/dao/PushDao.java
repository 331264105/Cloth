package com.didu.dao;

import com.didu.domain.Push;
import com.didu.sql.PushSql;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface PushDao {
    @Insert("insert into push(url,text)values(#{url},#{text})")
    int addImage(Push push);
    @Delete("delete from push where id=#{id}")
    int dePush(Push push);
    @SelectProvider(type = PushSql.class,method = "queryPush")
    List<Push> queryPush(Push push);
}
