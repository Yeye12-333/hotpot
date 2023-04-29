package com.runnersoftware.hot_pot_shop.model;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (Goods)实体类
 *
 * @author
 * @since 2021-06-02 15:42:02
 */
@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = -90949526202091258L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 菜品名字
     */
    private String name;
    /**
     * 菜品价格
     */
    private Double price;
    /**
     * 菜品图片
     */
    private String cover;
    /**
     * 菜品添加时间
     */
    private Date createTime;

}
