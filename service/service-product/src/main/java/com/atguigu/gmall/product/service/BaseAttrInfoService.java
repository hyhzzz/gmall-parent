package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author BigData
 * @description 针对表【base_attr_info(属性表)】的数据库操作Service
 * @createDate 2022-09-18 00:04:16
 */
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {

    //根据分类id获取平台属性名和值
    List<BaseAttrInfo> getAttrValueList(Long c1Id, Long c2Id, Long c3Id);

    //保存平台属性名和值
    void saveAttrAndValue(BaseAttrInfo baseAttrInfo);

    //修改平台属性名和值
    void updateAttrAndValue(BaseAttrInfo baseAttrInfo);
}
