package e1.controller;

import e1.model.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConfigurationController {
    static List<String> languages = new ArrayList<>();

    static {
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
    }

    static List<String> pages = new ArrayList<>();

    static {
        pages.add("5");
        pages.add("10");
        pages.add("15");
        pages.add("25");
        pages.add("50");
        pages.add("100");
    }

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("configuration", new Configuration());
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "/home";
    }

    @RequestMapping("/home")
    public String save(@ModelAttribute Configuration configuration, Model model) {
        String messenger = "Config successful";
        model.addAttribute("messenger", messenger);
        model.addAttribute("configuration", configuration);
        model.addAttribute("languages", languages);
        model.addAttribute("pages", pages);
        return "/home";
    }
}
