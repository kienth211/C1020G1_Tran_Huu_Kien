package p1.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import p1.blog.model.Credential;
import p1.blog.model.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/login")
    public String login(@ModelAttribute("credential") Credential credential, Model model,
                        HttpServletRequest request, @RequestParam(value = "language", required = false) String lang) {
        if (lang == null) {
            lang = "en";
        }
        model.addAttribute("lang", lang);
        return "login";
    }

    @PostMapping("/login")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model) {
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user", user);
        return "redirect:dashboard";
    }

}
