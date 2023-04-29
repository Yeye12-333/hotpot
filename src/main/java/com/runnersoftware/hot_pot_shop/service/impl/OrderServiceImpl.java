package com.runnersoftware.hot_pot_shop.service.impl;

import com.runnersoftware.hot_pot_shop.model.Order;
import com.runnersoftware.hot_pot_shop.mapper.OrderMapper;
import com.runnersoftware.hot_pot_shop.model.vo.OrderVo;
import com.runnersoftware.hot_pot_shop.service.OrderService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


/**
 * (Order)表服务实现类
 *
 * @author
 * @since 2021-06-02 17:07:44
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Integer id) {
        return this.orderMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderMapper.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderMapper.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.orderMapper.deleteById(id) > 0;
    }


    /**
     * 通过主键删除数据
     *
     * @param params 分页参数
     * @return 分页结果集
     */
    @Override
    public Map<String, Object> findAllByPage(Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>(3);
        Page<OrderVo> page = PageHelper.startPage(Integer.parseInt(params.get("pageNum").toString()), Integer.parseInt(params.get("pageSize").toString()));
        List<OrderVo> models = orderMapper.queryAll((OrderVo) params.get("entity"));
        map.put("rows", models);
        map.put("count", page.getTotal());
        return map;
    }

    @Override
    public List<OrderVo> findAll(OrderVo orderVo) {
        return orderMapper.queryAll(orderVo);
    }

    @Override
    public List<Map<String, Object>> chart() {
        return orderMapper.chart();
    }
}
