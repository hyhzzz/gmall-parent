package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author BigData
* @description 针对表【sku_info(库存单元表)】的数据库操作Mapper
* @createDate 2022-09-18 00:04:16
* @Entity com.atguigu.gmall.product.domain.SkuInfo
*/
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {


    //更新sku的上下架状态
    void updateSaleStatus(Long skuId, int status);
}




