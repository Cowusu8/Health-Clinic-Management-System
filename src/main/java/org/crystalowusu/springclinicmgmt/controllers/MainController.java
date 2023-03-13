// Required package modules
package org.crystalowusu.springclinicmgmt.controllers;
// Importing required classes
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j

@Controller //Annotation
public class MainController { //Class
    @GetMapping({"/index","/"}) //Index Page path
    public String homePage(){
        return "index";
    }

    @GetMapping("/login") //Admin Portal Path
    public String loginPortal(){
        return "login";
    }

    @GetMapping("/docportal") //Doctor's Portal Path
    public String docPortal(){
        return "doc_portal";
    }

    @GetMapping("/doctorpics") //Doctor's Pictures Page
    public String doc(){
        return "doc";
    }

    @GetMapping("/403") //Error 403 Page
    public String security(){
        return "403";
    }

    @GetMapping("/admindash") //Admin Dashboard Page
    public String adminDashPage(Principal p){
        log.warn(p.getName());
        return "admin_dash";
    }
    @GetMapping("/docdash") //Doctor's Dashboard Page
    public String docDashPage(){
        return "doc_dash";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }



}