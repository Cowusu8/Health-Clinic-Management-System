package org.crystalowusu.springclinicmgmt.services;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.dao.AdminRepoI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class AdminService {
    AdminRepoI adminRepoI;

    @Autowired
    public AdminService(AdminRepoI adminRepoI) {
        this.adminRepoI = adminRepoI;
    }
}
