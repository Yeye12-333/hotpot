package com.runnersoftware.hot_pot_shop.controller;

import com.github.pagehelper.Page;
import com.runnersoftware.hot_pot_shop.model.Goods;
import com.runnersoftware.hot_pot_shop.model.Scar;
import com.runnersoftware.hot_pot_shop.model.User;
import com.runnersoftware.hot_pot_shop.model.dto.SecurityUser;
import com.runnersoftware.hot_pot_shop.model.vo.OrderVo;
import com.runnersoftware.hot_pot_shop.model.vo.ScarVo;
import com.runnersoftware.hot_pot_shop.service.GoodsService;
import com.runnersoftware.hot_pot_shop.service.OrderService;
import com.runnersoftware.hot_pot_shop.service.ScarService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.runnersoftware.hot_pot_shop.model.Order;
import com.runnersoftware.hot_pot_shop.utils.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author
 * @since 2021-06-02 17:07:44
 */
@Controller
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;
    @Resource
    private ScarService scarService;
    @Resource
    private GoodsService goodsService;


    @GetMapping("/findAll")
    @ResponseBody
    public R findAll(@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
                     @RequestParam(value = "limit", defaultValue = "10", required = false) int pageSize,
                     OrderVo order) {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("entity", order);
        return R.ok().data(orderService.findAllByPage(params));
    }

    @PostMapping("/query/{id}")
    @ResponseBody
    public R findById(@PathVariable Integer id) {
        return R.ok().data("model", orderService.queryById(id));
    }


    @PostMapping("/create")
    @ResponseBody
    public R insertModel(Integer scarId) {
        Scar scar = scarService.queryById(scarId);
        Order order = new Order();
        BeanUtils.copyProperties(scar, order);
        Goods goods = goodsService.queryById(scar.getGoodsId());
        order.setTotal(goods.getPrice() * scar.getQuantity());
        order.setStatus(1);
        orderService.insert(order);
        scarService.deleteById(scarId);
        return R.ok();
    }

    @RequestMapping("/detail")
    public String findAllOrderByUser(Model model){
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        OrderVo orderVo = new OrderVo();
        orderVo.setUsername(securityUser.getUsername());
        List<OrderVo> list = orderService.findAll(orderVo);
        model.addAttribute("data", list);
        return "views/order/list";
    }

    @ResponseBody
    @RequestMapping("/chart")
    public R renderChart(){
        return R.ok().data("rows", orderService.chart());
    }


    @GetMapping("/remove/{id}")
    @ResponseBody
    public R removeModel(@PathVariable Integer id) {
        return R.auto(orderService.deleteById(id));
    }


    @PostMapping("/update")
    @ResponseBody
    public R updateModel(Order order) {
        orderService.update(order);
        return R.ok();
    }

}
