package com.clinicmgmt.springclinicmgmt.controllers;

import com.clinicmgmt.springclinicmgmt.repositories.Visit_InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Visit_InfoController {

    @Autowired
    private Visit_InfoRepository vRepo;
}
