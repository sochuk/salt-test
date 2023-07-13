package com.salt.salttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class KonsumenController {
    @GetMapping("/")
    public String index(){
        return "view-home";
    }
}
