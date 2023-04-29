package com.runnersoftware.hot_pot_shop.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author
 * @since 2021-06-02 15:42:06
 */
@Data
public class OrderVo implements Serializable {
    private static final long serialVersionUID = 361158817561476878L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 订单总价
     */
    private Double total;
    /**
     * 下单时间
     */
    private Date createTime;

    /**
     * 菜品图片
     */
    private String cover;
    /**
     * 用户名
     */
    private String username;
    /**
     * 菜品名字
     */
    private String name;

    /**
     * 订单状态
     */
    private Integer status;

    /**
     * 菜品数量
     */
    private Integer quantity;

}
