package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author BigData
* @description 针对表【base_attr_info(属性表)】的数据库操作Mapper
* @createDate 2022-09-18 00:04:16
* @Entity com.atguigu.gmall.product.domain.BaseAttrInfo
*/
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    //查询分类下的所有属性名和值
    List<BaseAttrInfo> getAttrValueList(@Param("c1Id") Long c1Id, @Param("c2Id") Long c2Id, @Param("c3Id") Long c3Id);
}




