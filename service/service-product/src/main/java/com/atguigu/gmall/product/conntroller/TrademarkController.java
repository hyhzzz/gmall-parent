package com.atguigu.gmall.product.conntroller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author coderhyh
 * @create 2022-09-18 7:04
 * 品牌功能控制器
 */

@RestController
@RequestMapping("/admin/product")
public class TrademarkController {

    @Autowired
    BaseTrademarkService baseTrademarkService;



    /**
     * 获取所有品牌列表
     * @return
     */
    @GetMapping("/baseTrademark/getTrademarkList")
    public Result baseTrademarkList() {
        List<BaseTrademark> list = baseTrademarkService.list();

        return Result.ok(list);
    }

    @GetMapping("/baseTrademark/{page}/{limit}")
    public Result baseTrademark(@PathVariable("page") Long page,
                                @PathVariable("limit") Long limit) {


        Page<BaseTrademark> p = new Page(page, limit);
        //分页查询的数据
        Page<BaseTrademark> result = baseTrademarkService.page(p);

        return Result.ok(result);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/baseTrademark/remove/{id}")
    public Result removeBaseTrademark(@PathVariable("id") Long id) {
        baseTrademarkService.removeById(id);
        return Result.ok();
    }


    /**
     * 按照id查询品牌
     *
     * @param id
     * @return
     */
    @GetMapping("/baseTrademark/get/{id}")
    public Result getBaseTrademarkById(@PathVariable("id") Long id) {

        BaseTrademark trademark = baseTrademarkService.getById(id);
        return Result.ok(trademark);
    }


    /**
     * 保存品牌
     *
     * @param baseTrademark
     * @return
     */
    @PostMapping("/baseTrademark/save")
    public Result saveTrademark(@RequestBody BaseTrademark baseTrademark) {

        baseTrademarkService.save(baseTrademark);

        return Result.ok();
    }

    /**
     * 修改品牌
     * @param baseTrademark
     * @return
     */
    @PutMapping("/baseTrademark/update")
    public Result updateTrademark(@RequestBody BaseTrademark baseTrademark) {

        baseTrademarkService.updateById(baseTrademark);

        return Result.ok();
    }

}
