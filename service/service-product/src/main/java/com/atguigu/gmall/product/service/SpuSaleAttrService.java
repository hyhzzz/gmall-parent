package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author BigData
* @description 针对表【spu_sale_attr(spu销售属性)】的数据库操作Service
* @createDate 2022-09-18 00:04:16
*/
public interface SpuSaleAttrService extends IService<SpuSaleAttr> {

    //获取spu的所有销售属性名和值
    List<SpuSaleAttr> getSpuSaleAttrList(Long spuId);

}
