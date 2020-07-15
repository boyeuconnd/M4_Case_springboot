package com.casestudy.casestudy.controller.api;


import com.casestudy.casestudy.models.Role;
import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.service.RoleService;
import com.casestudy.casestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class StaffApiController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("search")
    public List<Users> getallStaff(@RequestParam("s") String keyword){

        Role staffRole = roleService.getRoleById(2L);
        return (List<Users>) userService.findAllByRoleEqualsAndNickNameContaining(staffRole,keyword);
    }
}
