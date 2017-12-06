package com.didu.dao;

import com.didu.domain.Carousel;
import com.didu.sql.CarouselSql;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface CarouselDao {
    @Insert("insert into carousel (url)values(#{url})")
    int addImage(Carousel carousel);
    @SelectProvider(type = CarouselSql.class,method = "queryCarousels")
    List<Carousel> queryCarousel(Carousel carousel);
    @Update("update carousel set url=#{url} where id=#{id}")
    int updateCarousel(Carousel carousel);
    @Delete("delete from carousel where id=#{id}")
    int deCarousel(Carousel carousel);
}
