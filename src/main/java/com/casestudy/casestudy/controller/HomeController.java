package com.casestudy.casestudy.controller;



import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {



    @GetMapping("/")
    public String getHomePage(Model model){
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/contact")
    public String getContactPage(){return "contact";}


    @GetMapping("/reservation")
    public String getReservationPage(){
        return "/reservation";
    }
}
