package com.example.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/success")
    public String successPage(){
        return "success";
    }

    @GetMapping("/fail")
    public String failPage(){
        return "fail";
    }
}
