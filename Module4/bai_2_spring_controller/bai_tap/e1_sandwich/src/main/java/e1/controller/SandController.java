package e1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandController {
    @RequestMapping("/")
    public String showHome(){
        return "/home";
    }

    @RequestMapping("/home")
    public String showChoose(@RequestParam (required = false) String condiment, Model model){
        String messenger;
        if (condiment == null) {
            messenger = "Pls choose";
        } else {
            messenger = condiment;
        }
        model.addAttribute("messenger", messenger);
        return "/home";
    }
}
