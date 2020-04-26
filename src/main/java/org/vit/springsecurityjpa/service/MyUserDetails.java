package org.vit.springsecurityjpa.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.vit.springsecurityjpa.model.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private Integer id;
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;
    private boolean active;
    private boolean locked;
    private boolean expired;

    public MyUserDetails(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.authorities = Arrays.stream(user.getRoles().split(",")).
                map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());
        this.active = user.isActive();
        this.locked = user.isLocked();
        this.expired = user.isExpired();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !expired;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
