package com.didu.serviceImpl;

import com.didu.dao.ProductDao;
import com.didu.domain.Color;
import com.didu.domain.Product;
import com.didu.domain.Slider;
import com.didu.domain.Sliderdetail;
import com.didu.service.ProductService;
import com.didu.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Override
    public boolean addProduct(Product product) {
        return productDao.addProduct(product)>0?true:false;
    }

    @Override
    public List<Product> queryProduct(Product product,Page page) {
        return productDao.queryProduct(product,page);
    }

    @Override
    public int queryMax() {
        return productDao.queryMax();
    }

    @Override
    public boolean addSliderdetail(Sliderdetail sliderdetail) {
        return productDao.addSliderdetail(sliderdetail)>0?true:false;
    }

    @Override
    public boolean addSlider(Slider slider) {
        return productDao.addSlider(slider)>0?true:false;
    }

    @Override
    public List<Slider> querySlider(int id) {
        return productDao.querySlider(id);
    }

    @Override
    public List<Sliderdetail> querySliderdetail(int id) {
        return productDao.querySliderdetail(id);
    }

    @Override
    public boolean deSlider(int id) {
        return productDao.deSlider(id)>0?true:false;
    }

    @Override
    public boolean deSliderdetail(int id) {
        return productDao.deSliderdetail(id)>0?true:false;
    }

    @Override
    public boolean deProduct(int id) {
        return productDao.deProduct(id)>0?true:false;
    }

    @Override
    public Color queryProductColor(int id) {
        return productDao.queryProductColor(id);
    }

    @Override
    public Product queryProductById(int id) {
        return productDao.queryProductById(id);
    }
}
