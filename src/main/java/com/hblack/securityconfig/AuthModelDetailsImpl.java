package com.hblack.securityconfig;

import com.hblack.model.DefaultAuthModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class AuthModelDetailsImpl implements UserDetails {

    DefaultAuthModel defaultAuthModel;

    public AuthModelDetailsImpl(DefaultAuthModel defaultAuthModel) {
        this.defaultAuthModel = defaultAuthModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = defaultAuthModel.getRole();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        return Collections.singleton(authority);
    }

    @Override
    public String getPassword() {
        return defaultAuthModel.getPassword();
    }

    @Override
    public String getUsername() {
        return defaultAuthModel.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
