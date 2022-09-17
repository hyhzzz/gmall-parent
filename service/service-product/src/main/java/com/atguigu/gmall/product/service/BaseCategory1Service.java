package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author coderhyh
 * @create 2022-09-17 21:45
 */
public interface BaseCategory1Service extends IService<BaseCategory1> {

    //查询一级分类下的所有二级分类
    List<BaseCategory2> getCategory2(Long category1Id);

}
