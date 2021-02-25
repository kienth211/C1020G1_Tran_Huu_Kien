package p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import p1.model.Login;
import p1.model.User;
import p1.repository.UserRepoImp;

@Controller
public class FormController {

    @Autowired
    UserRepoImp userRepoImp;

    @RequestMapping("/")
    public ModelAndView showHome(){
        return new ModelAndView("/home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = userRepoImp.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
