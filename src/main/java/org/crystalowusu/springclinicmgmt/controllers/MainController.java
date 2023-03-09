package org.crystalowusu.springclinicmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@GetMapping("/index")
    public String homePage(){
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping("/403")
    public String security(){
        return "403";
    }

    @GetMapping("/admin")
    public String secondPage(){
        return "admin";
    }

    @GetMapping("/admindash")
    public String admindashPage(){
        return "admindash";
    }

    @GetMapping("/appointment")
    public String appointPage(){
        return "appointment";
    }

    @GetMapping("/doc-portal")
    public String docportal(){
        return "doctorsportal";
    }
}