package com.casestudy.controller.contract;

import com.casestudy.model.contract.AttachService;
import com.casestudy.model.contract.Contract;
import com.casestudy.model.customer.Customer;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.service.Service;
import com.casestudy.service.contract.AttachServiceService;
import com.casestudy.service.contract.ContractService;
import com.casestudy.service.customer.CustomerService;
import com.casestudy.service.employee.EmployeeService;
import com.casestudy.service.service.ServiceService;
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

@Controller
//@RequestMapping("/contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    AttachServiceService attachServiceService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceService serviceService;

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices() {
        return attachServiceService.findAll();
    }

    @ModelAttribute("employees")
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> customers() {
        return customerService.findAll();
    }

    @ModelAttribute("services")
    public List<Service> services() {
        return serviceService.findAll();
    }

    @RequestMapping("/contract")
    public String showHome(Model model,@PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
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
            return "redirect:/contract";
        }
    }

    @GetMapping("/contract/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") String id) {
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
            return "redirect:/contract";
        }
    }

    @GetMapping("/contract/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") String id) {
        return new ModelAndView("contract/delete","contract", contractService.findById(id));
    }

    @PostMapping("/contract/delete")
    public String doDelete(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        contractService.delete(contract);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/contract";
    }

    @GetMapping("/contract/find")
    public String doFind(Model model,@PageableDefault(value = 3) Pageable pageable){
        model.addAttribute("contracts", contractService.findContractsByCurrentDate(pageable));
        return "contract/find";
    }
}
