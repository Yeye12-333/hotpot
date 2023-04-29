package com.runnersoftware.hot_pot_shop.model;

import java.util.Date;
import java.io.Serializable;

import lombok.Data;

/**
 * (Scar)实体类
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@Data
public class Scar implements Serializable {
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


}
