package org.crystalowusu.springclinicmgmt.controllers;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@ControllerAdvice
@Slf4j
public class ClinicAdviceController {


    @ExceptionHandler(Exception.class)
    public ModelAndView catchAll(Exception e){


        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        log.debug("Exception e.getMessage(): " + e.getMessage());
        return modelAndView;

    }

}