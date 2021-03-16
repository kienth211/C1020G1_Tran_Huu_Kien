package com.casestudy.controller.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.CustomerService;
import com.casestudy.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public List<CustomerType> provinces() {
        return customerTypeService.findAll();
    }

    @GetMapping("/customer")
    public String showHome(Model model, Pageable pageable) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "customer/home";
    }

    @GetMapping("/customer/create")
    public ModelAndView showCreate() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/customer/create")
    public String doCreate(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/customer";
    }

    @GetMapping("/customer/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("customer/edit","customer", customerService.findById(id));
    }

    @PostMapping("/customer/edit")
    public String doEdit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/customer";
    }

    @GetMapping("/customer/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("customer/delete","customer", customerService.findById(id));
    }

    @PostMapping("/customer/delete")
    public String doDelete(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        customerService.delete(customer);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/customer";
    }
}
