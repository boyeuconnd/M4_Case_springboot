package com.casestudy.casestudy.controller.payment;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("payment")
public class PaymentController {

    @PostMapping("{id}")
    public String confirmPayment(){
        return "payment/confirm";
    }
}
