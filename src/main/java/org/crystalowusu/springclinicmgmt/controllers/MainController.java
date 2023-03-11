package org.crystalowusu.springclinicmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@GetMapping("/index")
    public String homePage(){
        return "index";
    }

    @GetMapping("/adminportal")
    public String adminportal(){
        return "admin_portal";
    }

    @GetMapping("/docportal")
    public String docportal(){
        return "doc_portal";
    }

    @GetMapping("/doctors")
    public String doc(){
        return "doc";
    }

    @GetMapping("/403")
    public String security(){
        return "403";
    }

    @GetMapping("/admindash")
    public String admindashPage(){
        return "admin_dash";
    }
    @GetMapping("/docdash")
    public String docdashPage(){
        return "doc_dash";
    }



}