package org.crystalowusu.springclinicmgmt.security;

import org.crystalowusu.springclinicmgmt.dao.AuthGroupRepoI;
import org.crystalowusu.springclinicmgmt.dao.DoctorsRepo;
//import org.crystalowusu.springclinicmgmt.dto.CombineUsers;
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
    public ClinicUserDetailsService(DoctorsRepo doctorsRepo, AuthGroupRepoI authGroupRepoI){
        this.doctorsRepo = doctorsRepo;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new ClinicUserPrincipal(
                doctorsRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username Not Found"))
                , authGroupRepoI.findByEmail(username));
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        List<CombineUsers> users = new ArrayList<>();
//        users = doctorsRepo.findAll().stream().map(doctor -> new CombineUsers(doctor.getUsername(), doctor.getPassword())).collect(Collectors.toList());
//       // users.addAll(adminRepo.findAll().stream().map(admin -> new CombineUsers(admin.getUsername(), admin.getPassword())).collect(Collectors.toList()));
//       Optional<CombineUsers> u = users.stream()
//                .filter(combineUsers -> combineUsers.getUsername().equals(username))
//                .map(combineUsers -> new CombineUsers(combineUsers.getUsername(), combineUsers.getPassword())).findFirst();
//
//
//        return new ClinicUserPrincipal(
//                u.orElseThrow(() -> new UsernameNotFoundException("Email Not Found"))
//                , authGroupRepoI.findByUsername(username));
//        }
    }


