package com.graphaware.pizzeria.security;

import com.graphaware.pizzeria.model.PizzeriaUser;
import com.graphaware.pizzeria.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzeriaUserPrincipal implements UserDetails {

    private PizzeriaUser user;

    public PizzeriaUserPrincipal(PizzeriaUser user) {
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (UserRole role: this.user.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.name()));
            }
            return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
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

    public PizzeriaUser getUser() {
        return user;
    }
}
