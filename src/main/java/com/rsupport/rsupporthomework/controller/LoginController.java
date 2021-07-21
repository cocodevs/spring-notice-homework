package com.rsupport.rsupporthomework.controller;

import com.rsupport.rsupporthomework.domain.Member;
import com.rsupport.rsupporthomework.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/signup")
    @ResponseBody
    public Long signupProc(@ModelAttribute Member member){
        return memberService.join(member);
    }
}
