package e1.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import e1.blog.model.Blog;
import e1.blog.service.BlogService;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public ModelAndView showHome(){
        return new ModelAndView("/home","blogs", blogService.findAll());
    }

    @GetMapping("/edit")
    public ModelAndView editBlog(@RequestParam Integer id) {
        return new ModelAndView("/edit","blog",blogService.findById(id));
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog Blog, RedirectAttributes redirectAttributes) {
        blogService.save(Blog);
        redirectAttributes.addFlashAttribute("messenger", "Blog edited successful");
        return "redirect:/";
    }

    @GetMapping("/create")
    public ModelAndView saveBlog() {
        return new ModelAndView("/create","blog",new Blog());
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog Blog, RedirectAttributes redirectAttributes) {
        blogService.save(Blog);
        redirectAttributes.addFlashAttribute("messenger", "Blog create successful");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("messenger", "Blog deleted successful");
        return "redirect:/";
    }

    @GetMapping("/view")
    public ModelAndView viewBlog(@RequestParam Integer id, Model model) {
        return new ModelAndView("/view","blog",blogService.findById(id));
    }
}
