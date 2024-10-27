package com.example.springboot.controller.hello;

import com.example.springboot.ApiResult.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloController {
    @Autowired
    private MessageSource messageSource;
    @GetMapping("/hellox")
    public String Hello(){
        System.out.println("Hello Springboot...");
        return "Hello Springboot";
    }
    @GetMapping("/helloresult")
    public Result<String> getStr(){
        return Result.success("hello Springboot");
    }

    @GetMapping("/helloerror")
    public String helloError(){
        int a = 1/0;
        return "helloerror";
    }

    @GetMapping("/i18n")
    public String i18n(){
        //LocaleContextHolder.getLocale()
        return messageSource.getMessage("msg", null, LocaleContextHolder.getLocale());
    }
}
