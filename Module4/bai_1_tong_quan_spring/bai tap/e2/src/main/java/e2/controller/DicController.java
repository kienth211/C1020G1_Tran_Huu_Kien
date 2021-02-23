package e2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DicController {
    @GetMapping("/")
    public String greeting() {
        return "/greeting";
    }

    @GetMapping("/dic")
        public String convert(@RequestParam String text, Model model){
        String messenger;
        Map<String, String> map = new HashMap<>();
        map.put("book", "sach");
        map.put("pen", "but");
        map.put("ruler", "thuoc");
        model.addAttribute("text",text);
        if (map.get(text) == null){
            messenger = "not found";
        } else {
            messenger = map.get(text);
        }
        model.addAttribute("messenger", messenger);
        return "/greeting";
    }
}
