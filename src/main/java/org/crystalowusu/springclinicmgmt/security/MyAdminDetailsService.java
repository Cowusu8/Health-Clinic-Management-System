package org.crystalowusu.springclinicmgmt.security;

import org.crystalowusu.springclinicmgmt.dao.AdminRepoI;
import org.crystalowusu.springclinicmgmt.dao.AuthGroupRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAdminDetailsService implements UserDetailsService {
    AdminRepoI adminRepoI;
    AuthGroupRepoI authGroupRepoI;

    @Autowired
    public MyAdminDetailsService(AdminRepoI adminRepoI, AuthGroupRepoI authGroupRepoI) {
        this.adminRepoI = adminRepoI;
        this.authGroupRepoI = authGroupRepoI;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyAdminPrincipal
                (adminRepoI.findByEmailAllIgnoreCase(username).orElseThrow(() -> new UsernameNotFoundException("Did not find the email" + username))
                        , authGroupRepoI.findByEmail(username));
    }
}
