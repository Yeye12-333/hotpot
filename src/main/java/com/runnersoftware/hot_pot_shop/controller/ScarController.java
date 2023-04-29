package com.runnersoftware.hot_pot_shop.controller;

import com.runnersoftware.hot_pot_shop.model.dto.SecurityUser;
import com.runnersoftware.hot_pot_shop.model.vo.ScarVo;
import com.runnersoftware.hot_pot_shop.service.ScarService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.runnersoftware.hot_pot_shop.model.Scar;
import com.runnersoftware.hot_pot_shop.utils.R;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

/**
 * (Scar)表控制层
 *
 * @author
 * @since 2021-06-02 15:42:07
 */
@RestController
@RequestMapping("scar")
public class ScarController {
    /**
     * 服务对象
     */
    @Resource
    private ScarService scarService;


    @GetMapping("/findAll")
    public R findAll(ScarVo scar) {
        Map<String, Object> params = new HashMap<String, Object>(3);
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        scar.setUserId(securityUser.getUser().getId());
        params.put("entity", scar);
        return R.ok().data(scarService.findAllByPage(params));
    }

    @PostMapping("/query/{id}")
    public R findById(@PathVariable Integer id) {
        return R.ok().data("model", scarService.queryById(id));
    }


    @PostMapping("/create")
    public R insertModel(Scar scar) {
        SecurityUser securityUser = (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        scar.setUserId(securityUser.getUser().getId());
        scar.setQuantity(1);
        scarService.insert(scar);
        return R.ok();
    }


    @GetMapping("/remove/{id}")
    public R removeModel(@PathVariable Integer id) {
        return R.auto(scarService.deleteById(id));
    }


    @PostMapping("/update")
    public R updateModel(Scar scar) {
        scarService.update(scar);
        return R.ok();
    }

}
