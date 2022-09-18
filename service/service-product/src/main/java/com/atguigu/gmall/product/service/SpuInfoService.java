package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SpuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author BigData
 * @description 针对表【spu_info(商品表)】的数据库操作Service
 * @createDate 2022-09-18 00:04:16
 */
public interface SpuInfoService extends IService<SpuInfo> {

    //商品保存
    void saveSpuInfo(SpuInfo spuInfo);
}
