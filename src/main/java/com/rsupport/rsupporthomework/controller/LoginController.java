package com.rsupport.rsupporthomework.controller;

import com.rsupport.rsupporthomework.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @GetMapping("/login")
    public String loginForm(){
        return "/login/login";
    }

    @GetMapping("/signup")
    public String signupForm(){
        return "/login/signup";
    }

}
