package p1.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import p1.customer.service.CustomerService;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showHome(){
        return new ModelAndView("home","customers",customerService.findAll());
    }
}
