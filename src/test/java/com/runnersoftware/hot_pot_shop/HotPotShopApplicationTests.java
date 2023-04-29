package com.runnersoftware.hot_pot_shop;

import com.runnersoftware.hot_pot_shop.model.User;
import com.runnersoftware.hot_pot_shop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HotPotShopApplicationTests {

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setRole(2);
        user.setUsername("admin");
        user.setPassword("123");
        userService.insert(user);
    }

}
