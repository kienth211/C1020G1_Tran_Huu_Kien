package p1.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import p1.customer.model.Customer;
import p1.customer.service.CustomerService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView showHome() {
        return new ModelAndView("home", "customers", customerService.findAll());
    }

    @GetMapping("/delete")
    public ModelAndView showDelete(@RequestParam Integer id) {
        Customer customer = customerService.findById(id);
        System.out.println(customer.toString());
        return new ModelAndView("delete", "customer", customer);
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Customer customer) {
        customerService.delete(customer);
        return "redirect:/";
    }
}
