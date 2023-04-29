package com.runnersoftware.hot_pot_shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.runnersoftware.hot_pot_shop.mapper")
@SpringBootApplication
public class HotPotShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotPotShopApplication.class, args);
    }

}
