package com.casestudy.casestudy.controller;

import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String getAdminPage(){
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public ModelAndView getListUsers(@RequestParam("keyword") Optional<String> keyword, @PageableDefault(size = 5) Pageable pageable){
        ModelAndView mv = new ModelAndView("admin/list-users");
        Page<Users> users ;

        if(keyword.isPresent()){
            users = userService.findAllByUserNameContaining(keyword.get(),pageable);
            mv.addObject("keyword",keyword.get());
            if(!users.hasContent()){
                mv.addObject("mess","No result");
            }
        }else {
            users = userService.findAll(pageable);
        }
        mv.addObject("users",users);
        return mv;
    }
}
