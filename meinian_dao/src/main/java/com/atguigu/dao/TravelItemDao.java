package com.atguigu.dao;

import com.atguigu.pojo.TravelItem;
import com.github.pagehelper.Page;

public interface TravelItemDao {
    void add(TravelItem travelItem);

    Page findPage(String queryString);
}
