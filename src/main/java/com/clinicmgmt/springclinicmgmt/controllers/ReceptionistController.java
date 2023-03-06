package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.dao.ReceptionistRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller @Slf4j
public class ReceptionistController {

    @Autowired
    private ReceptionistRepo rRepo;

    @GetMapping("receptionist")
    public String showReceptionist() {
        log.warn("test");
        return "receptionist";
    }

    @GetMapping("recepdash")
    public String showrecpt() {
        log.warn("test");
        return "recpt";
    }
}
