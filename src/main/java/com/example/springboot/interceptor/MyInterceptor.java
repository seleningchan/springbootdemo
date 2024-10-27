package com.example.springboot.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("begin preHandle");
        Boolean bool = HandlerInterceptor.super.preHandle(request, response, handler);
        System.out.println("end preHandle");
        return  bool;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("begin afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("end afterCompletion");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("begin postHandle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("end postHandle");
    }
}
