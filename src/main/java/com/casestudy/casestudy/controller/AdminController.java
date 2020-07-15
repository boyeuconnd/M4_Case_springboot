package com.casestudy.casestudy.controller;

import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.models.blogs.Post;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    UserService userService;

    @ModelAttribute("totalAccount")
    public Long getTotalAccount(){
        return userService.countAll();
    }

    @GetMapping("")
    public ModelAndView getAdminPage(Principal principal){
        ModelAndView mv = new ModelAndView("admin/dashboard");
        mv.addObject("admin",userService.findUsersByUserName(principal.getName()));
        return mv;
    }

    @GetMapping("/users")
    public ModelAndView getListUsers(@RequestParam("keyword") Optional<String> keyword, @PageableDefault(size = 10) Pageable pageable){
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

    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id){
        Users user = userService.findOne(id);
        ModelAndView mv = new ModelAndView("/admin/edit-user");
        mv.addObject("user",user);
        return mv;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Users user){
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("/admin/edit-user");
        modelAndView.addObject("user",new Users());
        modelAndView.addObject("mess","Update user successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute Users users, @PathVariable Long id, RedirectAttributes redirect){
        redirect.addFlashAttribute("mess","Delete user successfully");
        userService.delete(id);
        return "redirect:/admin/users";
    }
}
