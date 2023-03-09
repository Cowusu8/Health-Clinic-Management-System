package com.clinicmgmt.springclinicmgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

   /* public String homePage(){
        return "index";
    }*/


    @GetMapping("/login")
    public String postLoginPage() {
        // custom logic before showing login page...

        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("msg", "Hello World IndexPage");
        return "index";
    }




    @GetMapping("/403")
    public String access(){
        return "403";
    }

}