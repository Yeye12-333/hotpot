package com.runnersoftware.hot_pot_shop.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Scar)实体类
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@Data
public class ScarVo implements Serializable {
    private static final long serialVersionUID = 494400118169434898L;
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
     * 添加数量
     */
    private Integer quantity;
    /**
     * 添加时间
     */
    private Date createTime;
    /**
     * 菜品图片
     */
    private String cover;

    /**
     * 菜品名字
     */
    private String name;


    /**
     * 菜品价格
     */
    private Double price;

}
