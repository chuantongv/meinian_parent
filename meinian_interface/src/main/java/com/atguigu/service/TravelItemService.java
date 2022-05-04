package com.atguigu.service;


import com.atguigu.entity.PageResult;
import com.atguigu.pojo.TravelItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelTtem")

public interface TravelItemService {
    void add(TravelItem travelItem);

    PageResult findPage(Integer currentPage, Integer pageSize, String queryString);
}
