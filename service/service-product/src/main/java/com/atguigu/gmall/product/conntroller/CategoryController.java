package com.atguigu.gmall.product.conntroller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.BaseCategory1Service;
import com.atguigu.gmall.product.service.BaseCategory3Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author coderhyh
 * @create 2022-09-17 21:03
 * 三级分类业务控制器
 */
@RestController //我是一个控制器，并且所有方法上返回的数据是对象，都以json响应回去
@RequestMapping("/admin/product")
public class CategoryController {
    @Autowired
    BaseCategory1Service baseCategory1Service;

    @Autowired
    BaseCategory3Service baseCategory3Service;

    /**
     * 获取所有的一级分类
     *
     * @return
     */
    @GetMapping("/getCategory1")
    public Result getCategory1() {

        //查询所有一级分类
        List<BaseCategory1> category1s = baseCategory1Service.list();
        //封装到Result中
        return Result.ok(category1s);
    }

    /**
     * 获取一级分类下的所有二级分类
     *
     * @param category1Id
     * @return
     */

    @GetMapping("/getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") Long category1Id) {

        //查询一级分类下的所有二级分类
        List<BaseCategory2> baseCategory2s = baseCategory1Service.getCategory2(category1Id);

        return Result.ok(baseCategory2s);
    }

    /**
     * 获取二级分类下的所有三级分类
     *
     * @param category2Id
     * @return
     */
    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") Long category2Id) {


        List<BaseCategory3> baseCategory3s = baseCategory3Service.getCategory3(category2Id);
        return Result.ok(baseCategory3s);
    }

}
