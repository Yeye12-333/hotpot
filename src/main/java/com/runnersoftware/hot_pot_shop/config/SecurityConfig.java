package com.runnersoftware.hot_pot_shop.config;



import com.runnersoftware.hot_pot_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.HeaderWriterFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;


@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    private UserService userService;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable().authorizeRequests().anyRequest().authenticated().and()
                .formLogin().loginProcessingUrl("/login").loginPage("/ui/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                        if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))){
                            httpServletResponse.sendRedirect("/user/main");
                        }else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
                            httpServletResponse.sendRedirect("/backstage/index");
                        }
                    }
                }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.sendRedirect("/ui/login?error=" + URLEncoder.encode(e.getMessage(), "UTF-8"));
            }
        }).and().logout().logoutSuccessUrl("/logout").logoutSuccessUrl("/");

        HeaderWriter headerWriter = new HeaderWriter() {
            @Override
            public void writeHeaders(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
                httpServletResponse.setHeader("X-Frame-Options","SAMEORIGIN");
            }
        };
        HeaderWriterFilter filter = new HeaderWriterFilter(Collections.singletonList(headerWriter));
        http.addFilter(filter);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/", "/ui/login", "/css/**", "/js/**", "/images/**", "/fonts/**", "/layui/**", "/views/user/register.html", "/user/create");
    }
}
