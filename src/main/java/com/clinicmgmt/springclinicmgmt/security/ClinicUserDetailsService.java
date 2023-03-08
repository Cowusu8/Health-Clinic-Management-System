package com.clinicmgmt.springclinicmgmt.security;

import com.clinicmgmt.springclinicmgmt.dao.AuthGroupRepoI;
import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClinicUserDetailsService implements UserDetailsService {
    DoctorsRepo doctorsRepo;
    AuthGroupRepoI authGroupRepoI;

    @Autowired
    public ClinicUserDetailsService(DoctorsRepo doctorRepo, AuthGroupRepoI authGroupRepoI) {
        this.doctorsRepo = doctorsRepo;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new ClinicUserPrincipal(
                doctorsRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email Not Found"))
                , authGroupRepoI.findByUsername(username));
    }
}


