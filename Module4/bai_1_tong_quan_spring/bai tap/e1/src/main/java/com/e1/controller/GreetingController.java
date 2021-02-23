package com.e1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/")
//    public String greeting(@RequestParam String name, Model model){
        public String greeting(Model model){
        String name = "Thinh";
        model.addAttribute("name", name);
        return "/greeting";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam(required = false) String usd, Model model){
        Integer vnd = (Integer.parseInt(usd))*22000;
        model.addAttribute("vnd",vnd);
        return "/convert";
    }

}
