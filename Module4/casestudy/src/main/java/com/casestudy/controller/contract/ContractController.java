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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/contract")
    public String showHome(Model model, Pageable pageable) {
        model.addAttribute("contracts", contractService.findAll(pageable));
        return "contract/home";
    }

    @GetMapping("/contract/create")
    public ModelAndView showCreate() {
        return new ModelAndView("contract/create", "contract", new Contract());
    }

    @PostMapping("/contract/create")
    public String doCreate(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        contractService.save(contract);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/contract";
    }

    @GetMapping("/contract/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("contract/edit","contract", contractService.findById(id));
    }

    @PostMapping("/contract/edit")
    public String doEdit(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        contractService.save(contract);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/contract";
    }

    @GetMapping("/contract/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("contract/delete","contract", contractService.findById(id));
    }

    @PostMapping("/contract/delete")
    public String doDelete(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        contractService.delete(contract);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/contract";
    }
}
