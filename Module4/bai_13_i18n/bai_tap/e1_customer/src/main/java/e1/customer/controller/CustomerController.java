package e1.customer.controller;

import e1.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/")
    public String showHome(Model model, @RequestParam(value = "language", required = false) String lang){
        if (lang == null) {
            lang = "en";
        }
        model.addAttribute("lang", lang);
        model.addAttribute("customers", customerService.findAll());
        return "home";
    }

}
