package e2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/")
    public String showHome(){
        return "/home";
    }

    @RequestMapping("/home")
    public String showChoose(@RequestParam (required = false) Double number_1, Double number_2, String operator, Model model){
        Double num = null;
        switch (operator){
            case "+":
                num = number_1 + number_2;
                break;
            case "-":
                num = number_1 - number_2;
                break;
            case "*":
                num = number_1 * number_2;
                break;
            case "/":
                num = number_1 / number_2;
                break;
        }
        model.addAttribute("num", num);
        return "/home";
    }
}
