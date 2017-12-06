package com.didu.service;

import com.didu.domain.Carousel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/27.
 */
public interface CarouselService {
    boolean addImage(Carousel carousel);
    List<Carousel> queryCarousel(Carousel carousel);
    boolean updateCarousel(Carousel carousel);
}
