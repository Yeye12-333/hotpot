package com.runnersoftware.hot_pot_shop.model;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * (User)实体类
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 409774426264786568L;
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @JsonIgnore
    private String password;
    /**
     * 用户角色 1|2; 1普通用户 2管理员
     */
    private Integer role;
    /**
     * 用户创建时间
     */
    private Date createTime;



}
