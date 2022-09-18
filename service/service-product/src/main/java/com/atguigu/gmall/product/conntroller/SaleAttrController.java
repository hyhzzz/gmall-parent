package com.atguigu.gmall.product.conntroller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.product.service.BaseSaleAttrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author coderhyh
 * @create 2022-09-18 10:31
 */
@RestController
@RequestMapping("/admin/product")
public class SaleAttrController {

    @Autowired
    BaseSaleAttrService baseSaleAttrService;

    /**
     * 获取所有的销售属性的名
     *
     * @return
     */
    @RequestMapping("/baseSaleAttrList")
    public Result getBaseSaleAttrList() {
        List<BaseSaleAttr> list = baseSaleAttrService.list();

        return Result.ok(list);
    }
}
