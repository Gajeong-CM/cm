package com.example.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain(){

        return "main";
    }

    @GetMapping("/board")
    public String getBoard(){

        return "board";
    }

    @GetMapping("/map")
    public String getMap(){

        return "map";
    }

}
