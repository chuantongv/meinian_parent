package com.atguigu.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.dao.TravelItemDao;
import com.atguigu.entity.PageResult;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service(interfaceClass = TravelItemService.class)
@Transactional //声明式事务，所有方法都增加事务
public class TravelItemServiceImpl implements TravelItemService {


    @Autowired
    TravelItemDao travelItemDao;

    @Override
    public PageResult findPage(Integer currentPage, Integer pageSize, String queryString) {
        PageHelper.startPage(currentPage,pageSize);

        Page page = travelItemDao.findPage(queryString);

        return new PageResult(page.getTotal(),page.getResult());


    }

    @Override
   public void add(TravelItem travelItem){
      travelItemDao.add(travelItem);
  }

}
