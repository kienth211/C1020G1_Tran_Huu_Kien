package com.casestudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    @GetMapping("/403")
    public String show403() {
        return "403Page";
    }

    @GetMapping("/home_logged")
    public String logged(){
        return "home_logged";
    }
}
