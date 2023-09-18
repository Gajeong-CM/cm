package com.example.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMain() {

        return "main";
    }

    @GetMapping("/board")
    public String getBoard() {

        return "board";
    }

    @GetMapping("/map")
    public String getMap() {

        return "map";
    }

    @GetMapping("/schedule")
    public String getSchedule() {

        return "schedule";
    }

}
