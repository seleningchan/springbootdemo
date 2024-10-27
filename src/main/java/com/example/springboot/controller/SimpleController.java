package com.example.springboot.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.MessageSource;


@Getter
@Setter
@Controller
@ConfigurationProperties(prefix = "home")
public class SimpleController {
    String name;


    @RequestMapping("/index")
    public String homePage(Model model){
        model.addAttribute("name", name);
        model.addAttribute("msg","<h3>Hello</h3>");
        model.addAttribute("users", Arrays.asList("Richard","Elena","Batty"));
        return "index";
    }




}
