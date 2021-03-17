package com.casestudy.controller.employee;

import com.casestudy.model.employee.Division;
import com.casestudy.model.employee.EducationDegree;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.employee.Position;
import com.casestudy.service.employee.DivisionService;
import com.casestudy.service.employee.EducationDegreeService;
import com.casestudy.service.employee.EmployeeService;
import com.casestudy.service.employee.PositionService;
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
//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    PositionService positionService;

    @ModelAttribute("divisions")
    public List<Division> divisions() {
        return divisionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public List<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("positions")
    public List<Position> positions() {
        return positionService.findAll();
    }

    @RequestMapping("/employee")
    public String showHome(Model model, @RequestParam(name = "text") Optional<String> text,@PageableDefault(value = 3) Pageable pageable) {
        if (!text.isPresent()) {
            model.addAttribute("employees", employeeService.findAll(pageable));
        } else {
            model.addAttribute("employees", employeeService.findAllInput(pageable, text));
        }
        return "employee/home";
    }

    @GetMapping("/employee/create")
    public ModelAndView showCreate() {
        return new ModelAndView("employee/create", "employee", new Employee());
    }

    @PostMapping("/employee/create")
    public String doCreate(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit")
    public ModelAndView showEdit(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("employee/edit","employee", employeeService.findById(id));
    }

    @PostMapping("/employee/edit")
    public String doEdit(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        employeeService.save(employee);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete")
    public ModelAndView showDelete(@RequestParam(name = "id") Integer id) {
        return new ModelAndView("employee/delete","employee", employeeService.findById(id));
    }

    @PostMapping("/employee/delete")
    public String doDelete(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
//        blog.setDateUpdate(new Date());
        employeeService.delete(employee);
//        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/employee";
    }
}
