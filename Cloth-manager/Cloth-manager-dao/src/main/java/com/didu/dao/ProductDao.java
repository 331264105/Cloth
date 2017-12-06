package com.didu.dao;

import com.didu.domain.Color;
import com.didu.domain.Product;
import com.didu.domain.Slider;
import com.didu.domain.Sliderdetail;
import com.didu.sql.ProductSql;
import com.didu.utils.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ProductDao {
    @Insert("insert into product(name,price,units,num,statu,status,color,pname,fabric,season,sku,art,textture,url,place)values(#{name},#{price},#{units},#{num},#{statu},#{status},#{color},#{pname},#{fabric},#{season},#{sku},#{art},#{textture},#{url},#{place})")
    int addProduct(Product product);
    @SelectProvider(type = ProductSql.class,method = "queryProduct")
    List<Product> queryProduct(Product product,Page page);
    @Select("select max(id) from product")
    int queryMax();
    @Insert("insert into slider(url,cid)values(#{url},#{cid})")
    int addSlider(Slider slider);
    @Insert("insert into sliderdetail(url,cid)values(#{url},#{cid})")
    int addSliderdetail(Sliderdetail sliderdetail);
    @Select("select * from slider where cid=#{id}")
    List<Slider> querySlider(int id);
    @Select("select * from sliderdetail where cid=#{id}")
    List<Sliderdetail> querySliderdetail(int id);
    @Delete("delete from slider where cid=#{id}")
    int deSlider(int id);
    @Delete("delete from sliderdetail where cid=#{id}")
    int deSliderdetail(int id);
    @Delete("delete from product where id=#{id}")
    int deProduct(int id);
    @Select("select * from color where id=#{id}")
    Color queryProductColor(int id);
    @Select("select * from product where id=#{id}")
    Product queryProductById(int id);
}
