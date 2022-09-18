package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BigData
 * @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
 * @createDate 2022-09-18 00:04:16
 */
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo>
        implements BaseAttrInfoService {


    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueService baseAttrValueService;

    /**
     * 根据分类id获取平台属性名和值
     *
     * @param c1Id
     * @param c2Id
     * @param c3Id
     * @return
     */
    @Override
    public List<BaseAttrInfo> getAttrValueList(Long c1Id, Long c2Id, Long c3Id) {


        return baseAttrInfoMapper.getAttrValueList(c1Id, c2Id, c3Id);

    }

    /**
     * 保存平台属性和值
     *
     * @param baseAttrInfo
     */
    @Override
    @Transactional
    public void saveAttrAndValue(BaseAttrInfo baseAttrInfo) {

        //先把属性名信息保存
        baseAttrInfoMapper.insert(baseAttrInfo);

        Long id = baseAttrInfo.getId();
        //在把属性值保存
        List<BaseAttrValue> valueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : valueList) {
            value.setAttrId(id);
        }
        //批量保存
        baseAttrValueService.saveBatch(valueList);
    }

    /**
     * 修改平台属性名和值
     *
     * @param baseAttrInfo
     */
    @Override
    public void updateAttrAndValue(BaseAttrInfo baseAttrInfo) {

        //修改属性名(名、分类、层级)
        baseAttrInfoMapper.updateById(baseAttrInfo);

        //修改属性值
        List<Long> ids = new ArrayList<>();

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : attrValueList) {
            //新增(没带id，直接新增)
            if (value.getId() == null) {
                //回填属性id
                value.setAttrId(baseAttrInfo.getId());
                baseAttrValueService.save(value);
            }
            //修改(带了id，但是值要变化)
            if (value.getId() != null) {
                baseAttrValueService.updateById(value);
                ids.add(value.getId());
            }
        }

        //删除（前端没带的id，就是删除）
        if (ids.size() > 0) { //删除前端带的范围外的
            QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
            wrapper.eq("attr_id", baseAttrInfo.getId());
            wrapper.notIn("id", ids); //不在前端携帶的范围内的都删除

            baseAttrValueService.remove(wrapper);
        } else { // 代表全删
            QueryWrapper<BaseAttrValue> wrapper = new QueryWrapper<>();
            wrapper.eq("attr_id", baseAttrInfo.getId());
            baseAttrValueService.remove(wrapper);

        }
    }
}




