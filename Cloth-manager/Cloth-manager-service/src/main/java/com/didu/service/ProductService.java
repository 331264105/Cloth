package com.didu.service;

import com.didu.domain.Color;
import com.didu.domain.Product;
import com.didu.domain.Slider;
import com.didu.domain.Sliderdetail;
import com.didu.utils.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ProductService {
    boolean addProduct(Product product);
    List<Product> queryProduct(Product product,Page page);
    int queryMax();
    boolean addSliderdetail(Sliderdetail sliderdetail);
    boolean addSlider(Slider slider);
    List<Slider> querySlider(int id);
    List<Sliderdetail> querySliderdetail(int id);
    boolean deSlider(int id);
    boolean deSliderdetail(int id);
    boolean deProduct(int id);
    Color queryProductColor(int id);
    Product queryProductById(int id);
}
