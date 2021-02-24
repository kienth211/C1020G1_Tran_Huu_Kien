package controllers;

import model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.StudentService;
import services.StudentServiceImpl;

@Controller
public class StudentController {
    StudentService studentService = new StudentServiceImpl();

    @GetMapping("/students")
    public ModelAndView getStudentPage(){
        return new ModelAndView("home", "listStudent", studentService.getAllStudent());
    }

    @GetMapping("/student/create")
    public String getCreateForm(){
        return "create";
    }

    @PostMapping("/student/create")
    public String addNewStudent(@RequestParam int id, @RequestParam String name, Model model){
        studentService.createStudent(new Student(id, name));
        model.addAttribute("message", "Created");
        return "create";
    }
}
