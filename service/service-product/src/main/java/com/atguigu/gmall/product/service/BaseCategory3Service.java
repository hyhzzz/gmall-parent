package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory3;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author BigData
 * @description 针对表【base_category3(三级分类表)】的数据库操作Service
 * @createDate 2022-09-17 22:52:16
 */
public interface BaseCategory3Service extends IService<BaseCategory3> {

    //获取二级分类下的所有三级分类
    List<BaseCategory3> getCategory3(Long category2Id);

}
