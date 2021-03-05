package p1.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import p1.customer.model.Customer;
import p1.customer.model.Province;
import p1.customer.service.CustomerService;
import p1.customer.service.ProvinceService;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces(){
        return provinceService.findAll();
    }

    @GetMapping("/")
    public ModelAndView listCustomers(@RequestParam("s") Optional<String> s,@PageableDefault(size = 5) Pageable pageable){
        Page<Customer> customers;
        if(s.isPresent()){
            customers = customerService.findByName(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editProduct(@RequestParam Integer id) {
        return new ModelAndView("/edit","customer",customerService.findById(id));
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger", "Product edited successful");
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView saveProduct() {
        return new ModelAndView("/create","customer",new Customer());
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("messenger", "Product create successful");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("messenger", "Product deleted successful");
        return "redirect:/";
    }


}
