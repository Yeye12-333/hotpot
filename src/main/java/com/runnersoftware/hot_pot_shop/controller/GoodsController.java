package com.runnersoftware.hot_pot_shop.controller;

import com.runnersoftware.hot_pot_shop.service.GoodsService;
import org.springframework.web.bind.annotation.*;
import com.runnersoftware.hot_pot_shop.model.Goods;
import com.runnersoftware.hot_pot_shop.utils.R;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * (Goods)表控制层
 *
 * @author
 * @since 2021-06-02 15:42:04
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;


    @GetMapping("/findAll")
    public R findAll(@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
                     @RequestParam(value = "limit", defaultValue = "10", required = false) int pageSize,
                     Goods goods) {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("entity", goods);
        return R.ok().data(goodsService.findAllByPage(params));
    }

    @PostMapping("/query/{id}")
    public R findById(@PathVariable Integer id) {
        return R.ok().data("model", goodsService.queryById(id));
    }


    @PostMapping("/create")
    public R insertModel(Goods goods) {
        goodsService.insert(goods);
        return R.ok();
    }


    @GetMapping("/remove/{id}")
    public R removeModel(@PathVariable Integer id) {
        return R.auto(goodsService.deleteById(id));
    }


    @PostMapping("/update")
    public R updateModel(Goods goods) {
        goodsService.update(goods);
        return R.ok();
    }

}
