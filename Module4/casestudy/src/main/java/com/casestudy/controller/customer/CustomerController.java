package com.casestudy.controller.customer;

import com.casestudy.model.customer.Customer;
import com.casestudy.model.customer.CustomerType;
import com.casestudy.service.customer.CustomerService;
import com.casestudy.service.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping("/customer")
    public String showHome(Model model, @RequestParam(name = "text") Optional<String> text, @PageableDefault(value = 3) Pageable pageable) {
        if (!text.isPresent()) {
            model.addAttribute("customers", customerService.findAll(pageable));
        } else {
            model.addAttribute("customers", customerService.findAllInput(pageable, text));
        }
        return "customer/home";
    }

//    @GetMapping("/customer")
//    public String showHome(Model model, @PageableDefault(value = 3) Pageable pageable) {
//        model.addAttribute("customers", customerService.findAll(pageable));
//        return "customer/home";
//    }

    @GetMapping("/customer/create")
    public ModelAndView showCreate() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/customer/create")
    public String doCreate(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            return "/customer/create";
        }
        else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("messenger", "Customer create successful");
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") String id) {
        return new ModelAndView("customer/edit", "customer", customerService.findById(id));
    }

    @PostMapping("/customer/edit")
    public String doEdit(@Validated @ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes,
                         BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "/customer/edit";
        }
        else {
            customerService.save(customer);
            redirectAttributes.addFlashAttribute("messenger", "Customer edit successful");
            return "redirect:/customer";
        }
    }

    @GetMapping("/customer/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") String id) {
        return new ModelAndView("customer/delete", "customer", customerService.findById(id));
    }

    @PostMapping("/customer/delete")
    public String doDelete(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        customerService.delete(customer);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/customer";
    }

//    @GetMapping("/customer/find")
//    public String doFind(Model model,@PageableDefault(value = 3) Pageable pageable){
//        model.addAttribute("customers", customerService.findAllBetween(pageable));
//        return "customer/find";
//    }

}
