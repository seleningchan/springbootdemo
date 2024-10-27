package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {
    @RequestMapping(value = "/loginx")
    public String loginx(){
        return "loginx";
    }

    @GetMapping("/hello")
    public String hello(){
        log.info("hello starting...");
        return "hello";
    }

    @GetMapping("/home")
    public String home(){
        log.info("home starting...");
        return "home";
    }

    @GetMapping("/login")
    public String login(){
        log.info("login starting...");
        return "login";
    }
}