package com.clinicmgmt.springclinicmgmt.security;

import com.clinicmgmt.springclinicmgmt.dao.AdminRepo;
import com.clinicmgmt.springclinicmgmt.dao.AuthGroupRepoI;
import com.clinicmgmt.springclinicmgmt.dao.DoctorsRepo;
import com.clinicmgmt.springclinicmgmt.dto.CombineUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClinicUserDetailsService implements UserDetailsService {
    AdminRepo adminRepo;
    DoctorsRepo doctorsRepo;
    AuthGroupRepoI authGroupRepoI;

    @Autowired
    public ClinicUserDetailsService(DoctorsRepo doctorsRepo, AuthGroupRepoI authGroupRepoI, AdminRepo adminRepo) {
        this.doctorsRepo = doctorsRepo;
        this.authGroupRepoI = authGroupRepoI;
        this.adminRepo = adminRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<CombineUsers> users = new ArrayList<>();
        users = doctorsRepo.findAll().stream().map(doctor -> new CombineUsers(doctor.getUsername(), doctor.getPassword())).collect(Collectors.toList());
        users.addAll(adminRepo.findAll().stream().map(admin -> new CombineUsers(admin.getUsername(), admin.getPassword())).collect(Collectors.toList()));
       Optional<CombineUsers> u = users.stream()
                .filter(combineUsers -> combineUsers.getUsername().equals(username))
                .map(combineUsers -> new CombineUsers(combineUsers.getUsername(), combineUsers.getPassword())).findFirst();


        return new ClinicUserPrincipal(
                u.orElseThrow(() -> new UsernameNotFoundException("Email Not Found"))
                , authGroupRepoI.findByUsername(username));
        }
    }


