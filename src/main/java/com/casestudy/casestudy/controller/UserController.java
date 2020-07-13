package com.casestudy.casestudy.controller;



import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.models.UsersForm;
import com.casestudy.casestudy.service.RoleService;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    Environment env;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @GetMapping("create")
    public ModelAndView getRegisterForm(){
        ModelAndView mv = new ModelAndView("user/create");
        mv.addObject("newUser",new UsersForm());
        return mv;
    }

    @PostMapping("create")
    public ModelAndView userRegister(@Validated @ModelAttribute("newUser") UsersForm usersForm, BindingResult bindingResult){

        ModelAndView mv = null;
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("user/create");
        }else {
            Users newUser = cloneFromUserformToUser(usersForm);

            //create direct file path to new avatar file
            MultipartFile multipartFile = usersForm.getAvatar();
            String filepath = env.getProperty("upload.path").toString();
            String fileName = newUser.getUserName() + "-" + multipartFile.getOriginalFilename();


            mv = new ModelAndView("user/create");
            Role staffRole = roleService.getRoleById(3L);

            //set avatar avatar link and set default role user
            newUser.setAvatar(fileName);
            newUser.setRole(staffRole);
            if (userService.save(newUser) != null) {
                try {
                    FileCopyUtils.copy(usersForm.getAvatar().getBytes(), new File(filepath + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mv.addObject("newUser", new UsersForm());
                mv.addObject("mess", "Register Success");
            } else {
                mv.addObject("newUser", usersForm);
                mv.addObject("mess", "Register Not Finish");
            }
        }
        return mv;
    }

    private Users cloneFromUserformToUser(@ModelAttribute UsersForm usersForm) {
        Users users = new Users();
        users.setFirstName(usersForm.getFirstName());
        users.setLastName(usersForm.getLastName());
        users.setUserName(usersForm.getUserName());
        users.setEmail(usersForm.getEmail());
        users.setPassword(usersForm.getPassword());
        users.setAvatar(null);
        return users;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Users editUser = userService.findOne(id);
        ModelAndView mv = new ModelAndView("user/update");
        mv.addObject("editUser",editUser);
        return mv;
    }

    @PostMapping("edit/{id}")
    public ModelAndView updateInfo(@ModelAttribute("editUser") UsersForm usersForm,
                                   @PathVariable Long id){
        ModelAndView mv = new ModelAndView("user/update");

        Users editUser = updateUserInfo(usersForm, id);


        MultipartFile multipartFile = usersForm.getAvatar();
        if(!multipartFile.getOriginalFilename().equals("")) {
            String filepath = env.getProperty("upload.path").toString();
            String fileName = editUser.getUserName() + "-" + multipartFile.getOriginalFilename();
            editUser.setAvatar(fileName);
            try {
                FileCopyUtils.copy(usersForm.getAvatar().getBytes(), new File(filepath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        userService.save(editUser);
        mv.addObject("mess", "Update Success");
        mv.addObject("newUser", usersForm);


        return mv;
    }

    private Users updateUserInfo( UsersForm usersForm, Long id) {
        Users editUser = userService.findOne(id);
        editUser.setFirstName(usersForm.getFirstName());
        editUser.setLastName(usersForm.getLastName());
        editUser.setEmail(usersForm.getEmail());
        return editUser;
    }

}
