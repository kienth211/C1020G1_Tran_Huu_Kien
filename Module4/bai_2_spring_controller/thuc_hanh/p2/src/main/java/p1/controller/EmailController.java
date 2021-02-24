package p1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @RequestMapping("/")
    public String showHome(){
        return "/home";
    }

    @RequestMapping("/home")
    public String showFormat(@RequestParam String email, Model model) {
        String messenger;
        String regex = "\\w+@\\w+(\\.\\w+){1,5}";
//        if (email == null) {
////            return "/home";
////        }
        if (email.matches(regex)) {
            messenger = "right format";
        } else {
            messenger = "wrong format";
        }
        model.addAttribute("messenger", messenger);
        return "/home";
    }
}
