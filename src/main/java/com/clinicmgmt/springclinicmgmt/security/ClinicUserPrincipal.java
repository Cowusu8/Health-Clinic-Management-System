package com.clinicmgmt.springclinicmgmt.security;


import com.clinicmgmt.springclinicmgmt.models.AuthGroup;
import com.clinicmgmt.springclinicmgmt.models.Doctor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ClinicUserPrincipal implements UserDetails {
    private Doctor doctor;
    private List<AuthGroup> authGroup;

    public ClinicUserPrincipal(Doctor doctor, List<AuthGroup> authGroup) {

        this.doctor = doctor;
        this.authGroup=authGroup;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authGroup.stream().map(auth -> new SimpleGrantedAuthority(auth.getRole())).collect(Collectors.toList());

    }

    @Override
    public String getPassword() {
        return doctor.getPassword();
    }

    @Override
    public String getUsername() {
        return doctor.getUserName();
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