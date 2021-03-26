package com.test.controller;

import com.test.model.contract.Contract;
import com.test.model.customer.Customer;
import com.test.service.contract.ContractService;
import com.test.service.customer.CustomerService;
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

import java.util.List;
import java.util.Optional;

@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    CustomerService customerService;

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }

    @RequestMapping("/")
    public String showHome(Model model, @RequestParam(name = "text") Optional<String> text, @PageableDefault(value = 3) Pageable pageable) {
        if (!text.isPresent()) {
            model.addAttribute("contracts", contractService.findAll(pageable));
        } else {
            model.addAttribute("contracts", contractService.findAllInput(pageable, text));
        }
        return "contract/home";
    }

    @GetMapping("/contract/create")
    public ModelAndView showCreate() {
        return new ModelAndView("contract/create", "contract", new Contract());
    }

    @PostMapping("/contract/create")
    public String doCreate(@Validated @ModelAttribute("contract") Contract contract, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            return "/contract/create";
        }
        else {
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("messenger", "Contract create successful");
            return "redirect:/";
        }
    }

    @GetMapping("/contract/view")
    public ModelAndView showView(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("contract/view","contract", contractService.findById(id));
    }

    @GetMapping("/contract/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("contract/edit","contract", contractService.findById(id));
    }

    @PostMapping("/contract/edit")
    public String doEdit(@Validated @ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes,
                         BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return "/contract/edit";
        }
        else {
            contractService.save(contract);
            redirectAttributes.addFlashAttribute("messenger", "Contract edit successful");
            return "redirect:/";
        }
    }

    @GetMapping("/contract/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("contract/delete","contract", contractService.findById(id));
    }

    @PostMapping("/contract/delete")
    public String doDelete(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        System.out.println("delete");
        contractService.delete(contract);
        redirectAttributes.addFlashAttribute("messenger", "Contract delete successful");
        return "redirect:/";
    }

}
