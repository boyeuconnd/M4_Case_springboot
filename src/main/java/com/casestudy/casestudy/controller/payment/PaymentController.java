package com.casestudy.casestudy.controller.payment;


import com.casestudy.casestudy.controller.UserController;
import com.casestudy.casestudy.models.Users;
import com.casestudy.casestudy.service.UserService;
import com.casestudy.casestudy.service.staff.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    UserService userService;

    @Autowired
    StatusService statusService;

    @PostMapping("{id}")
    public String confirmPayment(@PathVariable Long id, Principal principal){
        Users customer = userService.findUsersByUserName(principal.getName());
        if(customer.getRole().getId()==2){
            return "exception/403";
        }

        //Set status to hideStaff to busy
        Users staff = userService.findOne(id);
        staff.setStatus(statusService.findById(9L));
        userService.save(staff);

        return "payment/confirm";
    }
}
