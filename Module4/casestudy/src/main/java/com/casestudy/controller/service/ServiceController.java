package com.casestudy.controller.service;

import com.casestudy.model.service.RentType;
import com.casestudy.model.service.Service;
import com.casestudy.model.service.ServiceType;
import com.casestudy.service.service.RentTypeService;
import com.casestudy.service.service.ServiceService;
import com.casestudy.service.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceTypeService serviceTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @ModelAttribute("serviceTypes")
    public List<ServiceType> serviceType() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public List<RentType> rentType() {
        return rentTypeService.findAll();
    }

    @RequestMapping("/service")
    public String showHome(Model model, @RequestParam(name = "text") Optional<String> text, @PageableDefault(value = 3) Pageable pageable) {
        if (!text.isPresent()) {
            model.addAttribute("services", serviceService.findAll(pageable));
        } else {
            model.addAttribute("services", serviceService.findAllInput(pageable, text));
        }
        return "service/home";
    }

    @GetMapping("/service/create")
    public ModelAndView showCreate() {
        return new ModelAndView("service/create", "service", new Service());
    }

    @PostMapping("/service/create")
    public String doCreate(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        serviceService.save(service);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/service";
    }

    @GetMapping("/service/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("service/edit","service", serviceService.findById(id));
    }

    @PostMapping("/service/edit")
    public String doEdit(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        serviceService.save(service);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/service";
    }

    @GetMapping("/service/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("service/delete","service", serviceService.findById(id));
    }

    @PostMapping("/service/delete")
    public String doDelete(@ModelAttribute Service service, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        serviceService.delete(service);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/service";
    }
}
