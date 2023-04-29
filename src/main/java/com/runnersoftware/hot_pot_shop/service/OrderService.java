package com.runnersoftware.hot_pot_shop.service;

import com.runnersoftware.hot_pot_shop.model.Order;
import com.runnersoftware.hot_pot_shop.model.vo.OrderVo;

import java.util.List;
import java.util.Map;

/**
 * (Order)表服务接口
 *
 * @author
 * @since 2021-06-02 17:07:44
 */
public interface OrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 分页查询所有数据
     *
     * @param params 分页信息及查询条件
     * @return 分页结果集
     */
    Map<String, Object> findAllByPage(Map<String, Object> params);

    List<OrderVo> findAll(OrderVo orderVo);

    List<Map<String, Object>> chart();
}
