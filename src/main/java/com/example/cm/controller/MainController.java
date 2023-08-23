package com.example.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

    @GetMapping("/layout")
    public String layout(){

        //return "layout/layout";
        return "main";
    }

}
