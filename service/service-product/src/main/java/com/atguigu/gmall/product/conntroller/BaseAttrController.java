package com.atguigu.gmall.product.conntroller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.atguigu.gmall.product.service.BaseAttrValueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author coderhyh
 * @create 2022-09-18 0:00
 */

@Slf4j
@RestController
@RequestMapping("/admin/product")
public class BaseAttrController {


    @Autowired
    BaseAttrInfoService baseAttrInfoService;

    @Autowired
    BaseAttrValueService baseAttrValueService;

    /**
     * 根据分类id获取平台属性名和值
     *
     * @param c1Id 一级分类id
     * @param c2Id 二级分类id
     * @param c3Id 三级分类id
     * @return
     */
    @GetMapping("/attrInfoList/{c1id}/{c2id}/{c3id}")
    public Result getAttrValueList(@PathVariable("c1id") Long c1Id,
                                   @PathVariable("c2id") Long c2Id,
                                   @PathVariable("c3id") Long c3Id) {

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.getAttrValueList(c1Id, c2Id, c3Id);
        return Result.ok(baseAttrInfoList);
    }

    /**
     * 保存平台属性    修改保存二合一
     *
     * @return
     */
    @PostMapping("/saveAttrInfo")
    //把json数据转成javabean
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {


        log.info("保存/修改属性：", baseAttrInfo);
        if(baseAttrInfo.getId()!=null){
            //修改
            baseAttrInfoService.updateAttrAndValue(baseAttrInfo);
        }else{
            //新增
            baseAttrInfoService.saveAttrAndValue(baseAttrInfo);
        }

        return Result.ok();
    }

    /**
     * 根据平台属性ID获取平台属性对象数据
     *
     * @param attrId
     * @return
     */
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") Long attrId) {

        List<BaseAttrValue> values = baseAttrValueService.getAttrValueList(attrId);

        return Result.ok(values);
    }
}
