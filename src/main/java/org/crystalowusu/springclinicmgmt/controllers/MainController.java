// Required package modules
package org.crystalowusu.springclinicmgmt.controllers;
// Importing required classes
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Annotation
public class MainController { //Class
    @GetMapping("/index") //Index Page path
    public String homePage(){
        return "index";
    }

    @GetMapping("/login") //Admin Portal Path
    public String adminPortal(){
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

//    @GetMapping("/403") //Error 403 Page
//    public String security(){
//        return "403";
//    }

    @GetMapping("/admindash") //Admin Dashboard Page
    public String adminDashPage(){
        return "admin_dash";
    }
    @GetMapping("/docdash") //Doctor's Dashboard Page
    public String docDashPage(){
        return "doc_dash";
    }



}