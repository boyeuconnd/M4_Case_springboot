package com.casestudy.casestudy.controller.exception;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandling {

    @GetMapping("/403")
    public String get403page(){
        return "exception/403";
    }
}
