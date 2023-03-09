package org.crystalowusu.springclinicmgmt.controllers;

import lombok.extern.slf4j.Slf4j;
import org.crystalowusu.springclinicmgmt.dao.ReceptionistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @Slf4j
public class ReceptionistController {

    @Autowired
    private ReceptionistRepo rRepo;

    @GetMapping("/receptionist") //http://localhost:8080/receptionist
    public String showReceptionist() {
        return "receptionist";
    }

    @GetMapping("/recepdash") //http://localhost:8080/recepdash
    public String showrecpt() {
        log.warn("test");
        return "recptdash";
    }


}