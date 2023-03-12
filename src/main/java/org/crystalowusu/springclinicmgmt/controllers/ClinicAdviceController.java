//Required package modules
package org.crystalowusu.springclinicmgmt.controllers;

// Importing required classes
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

// Annotations
@ControllerAdvice
@Slf4j
public class ClinicAdviceController { //Class


    @ExceptionHandler(Exception.class)
    public ModelAndView catchAll(Exception e){


        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", e.getMessage());
        log.debug("Exception e.getMessage(): " + e.getMessage());
        return modelAndView;

    }

}