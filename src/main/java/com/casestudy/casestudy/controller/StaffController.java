package com.casestudy.casestudy.controller;


import com.casestudy.casestudy.models.*;
import com.casestudy.casestudy.service.RoleService;
import com.casestudy.casestudy.service.UserService;
import com.casestudy.casestudy.service.staff.RankService;
import com.casestudy.casestudy.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("staff")
public class StaffController {

    @Autowired
    RankService rankService;

    @Autowired
    StatusService statusService;


    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @ModelAttribute("allRanks")
    public Iterable<Rank> callAllRank(){
        return rankService.showRanks();
    }

    @ModelAttribute("allStatus")
    public Iterable<Status> callAllStatus(){
        return statusService.showStatus() ;
    }

    @GetMapping("promote")
    public ModelAndView showPromoteForm(Principal principal){
        Users promoteUser = userService.findUsersByUserName(principal.getName());
        ModelAndView mv = new ModelAndView("staff/promote");
        mv.addObject("promoteUser",promoteUser);
        return mv;
    }

    @PostMapping("promote")
    public ModelAndView becomeStaff(@RequestParam("nickName") String nickName,
                                    @RequestParam("price") Float price,
                                    @RequestParam("rank")Long rank,
                                    @RequestParam("status")Long status,
                                    Principal principal){
        ModelAndView mv = new ModelAndView("staff/promote");

        Users staff = userService.findUsersByUserName(principal.getName());
        staff.setNickName(nickName);
        staff.setPrice(price);
        staff.setRank(rankService.findById(rank));
        staff.setStatus(statusService.findById(status));

        //Set role form customer to staff role
        Role staffRole = roleService.getRoleById(2L);
        staff.setRole(staffRole);

        if(userService.save(staff)!=null){
            mv.addObject("staff",new Users());
            mv.addObject("mess","Register Success");
        }else {
            mv.addObject("staff",staff);
            mv.addObject("mess","Register Not Finish");

        }
        return mv;
    }

    @GetMapping("")
    public ModelAndView showStaffList(Pageable pageable){
        Page<Users> staffList;
        ModelAndView mv = new ModelAndView("menu");
        staffList = userService.findAllByRoleEquals(roleService.getRoleById(2L),pageable);
        mv.addObject("staffList",staffList);
        return mv;
    }

    @GetMapping("view/{id}")
    public ModelAndView showStaffDetail(@PathVariable Long id){
        ModelAndView mv = new ModelAndView("staff/detail");
        Users user = userService.findOne(id);
        mv.addObject("userStaff",user);
        return mv;
    }

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Long id){
        return "staff/update";
    }
}
