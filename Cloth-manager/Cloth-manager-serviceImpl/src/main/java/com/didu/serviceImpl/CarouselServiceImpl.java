package com.didu.serviceImpl;

import com.didu.dao.CarouselDao;
import com.didu.domain.Carousel;
import com.didu.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;
    @Override
    public boolean addImage(Carousel carousel) {
        return carouselDao.addImage(carousel)>0?true:false;
    }

    @Override
    public List<Carousel> queryCarousel(Carousel carousel) {
        return carouselDao.queryCarousel(carousel);
    }

    @Override
    public boolean updateCarousel(Carousel carousel) {
        return carouselDao.updateCarousel(carousel)>0?true:false;
    }
}
