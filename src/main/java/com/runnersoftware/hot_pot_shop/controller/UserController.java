package com.runnersoftware.hot_pot_shop.controller;

import com.runnersoftware.hot_pot_shop.service.UserService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.runnersoftware.hot_pot_shop.model.User;
import com.runnersoftware.hot_pot_shop.utils.R;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;


    @GetMapping("/findAll")
    public R findAll(@RequestParam(value = "page", defaultValue = "1", required = false) int pageNum,
                     @RequestParam(value = "limit", defaultValue = "10", required = false) int pageSize,
                     User user) {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        params.put("entity", user);
        return R.ok().data(userService.findAllByPage(params));
    }

    @PostMapping("/query/{id}")
    public R findById(@PathVariable Integer id) {
        return R.ok().data("model", userService.queryById(id));
    }


    @PostMapping("/create")
    public R insertModel(User user) {
        if (StringUtils.isEmpty(user.getRole())){
            user.setRole(1);
        }
        userService.insert(user);
        return R.ok();
    }


    @GetMapping("/remove/{id}")
    public R removeModel(@PathVariable Integer id) {
        return R.auto(userService.deleteById(id));
    }


    @PostMapping("/update")
    public R updateModel(User user) {
        userService.update(user);
        return R.ok();
    }

}
