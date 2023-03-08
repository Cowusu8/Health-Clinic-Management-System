package com.clinicmgmt.springclinicmgmt.security;

import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.dao.ReceptionistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service

public class MyUserDetailsService implements UserDetailsService {


    DoctorsRepo doctorsRepo;
    ReceptionistRepo receptionistRepo;

    @Autowired
    public MyUserDetailsService(DoctorsRepo doctorsRepo, ReceptionistRepo receptionistRepo) {
        this.doctorsRepo = doctorsRepo;
        this.receptionistRepo = receptionistRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserPrincipal
                (doctorsRepo.findByEmailAllIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("Did not find the email" + username))
                        , receptionistRepo.findByEmail(username));
    }
}