package com.runnersoftware.hot_pot_shop.model.dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class SecurityUser extends User {

    private final com.runnersoftware.hot_pot_shop.model.User user;

    public SecurityUser(com.runnersoftware.hot_pot_shop.model.User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), user.getPassword(), authorities);
        this.user = user;
    }

}
