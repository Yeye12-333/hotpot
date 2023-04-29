package com.runnersoftware.hot_pot_shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("backstage/index").setViewName("main");
        registry.addViewController("/ui/login").setViewName("index");
        registry.addViewController("/").setViewName("redirect:/ui/login");

        registry.addViewController("/user/main").setViewName("views/user/main");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/views/**").addResourceLocations("classpath:/templates/views/");
    }
}
