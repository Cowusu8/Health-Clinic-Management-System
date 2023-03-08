package com.clinicmgmt.springclinicmgmt.security;

import com.clinicmgmt.springclinicmgmt.models.Doctors;
import com.clinicmgmt.springclinicmgmt.models.Receptionist;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserPrincipal implements UserDetails {

    Doctors doctors;
    List<Receptionist> receptionists;


    public MyUserPrincipal(Doctors doctors, List<Receptionist> receptionists) {
        this.doctors = doctors;
        this.receptionists = receptionists;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return receptionists.stream().map( auth -> new SimpleGrantedAuthority(auth.getUsername())).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return doctors.getPassword();
    }

    @Override
    public String getUsername() {
        return doctors.getUsername();
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