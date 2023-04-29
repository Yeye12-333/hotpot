package com.runnersoftware.hot_pot_shop.model;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (Order)实体类
 *
 * @author
 * @since 2021-06-02 17:10:03
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 908225727259831055L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 菜品id
     */
    private Integer goodsId;
    /**
     * 菜品数量
     */
    private Integer quantity;
    /**
     * 订单总价
     */
    private Double total;
    /**
     * 订单状态
     */
    private Integer status;
    /**
     * 下单时间
     */
    private Date createTime;


}
