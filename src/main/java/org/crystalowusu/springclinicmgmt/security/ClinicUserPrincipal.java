package org.crystalowusu.springclinicmgmt.security;


import org.crystalowusu.springclinicmgmt.dto.CombineUsers;
import org.crystalowusu.springclinicmgmt.models.AuthGroup;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicUserPrincipal implements UserDetails {
    private CombineUsers combineUsers;
    private List<AuthGroup> authGroup;

    public ClinicUserPrincipal(CombineUsers combineUsers, List<AuthGroup> authGroup) {

        this.combineUsers = combineUsers;
        this.authGroup=authGroup;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authGroup.stream().map(auth -> new SimpleGrantedAuthority(auth.getRole())).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return combineUsers.getPassword();
    }

    @Override
    public String getUsername() {
        return combineUsers.getUsername();
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