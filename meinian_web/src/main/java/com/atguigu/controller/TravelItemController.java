package com.atguigu.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.entity.PageResult;
import com.atguigu.entity.QueryPageBean;
import com.atguigu.entity.Result;
import com.atguigu.entity.constant.MessageConstant;
import com.atguigu.pojo.TravelItem;
import com.atguigu.service.TravelItemService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/travelItem")


public class TravelItemController {

   @Reference
   //远程调用服务
    TravelItemService travelItemService;

   @RequestMapping("/findPage")
   public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
       PageResult pageResult = travelItemService.findPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize(),queryPageBean.getQueryString());
       return pageResult;
   }

      @RequestMapping("/add")
     public Result add(@RequestBody TravelItem travelItem){

          try{
              travelItemService.add(travelItem);
              return new Result(true,MessageConstant.ADD_TRAVELITEM_SUCCESS);
          }catch(Exception e){
              e.printStackTrace();
              return new Result(false,MessageConstant.ADD_TRAVELITEM_FAIL);
          }
     }

}
