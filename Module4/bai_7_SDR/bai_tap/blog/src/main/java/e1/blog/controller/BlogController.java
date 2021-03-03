package e1.blog.controller;

import e1.blog.model.Category;
import e1.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import java.util.Date;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> provinces(){
        return categoryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showHome(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5) Pageable pageable){
        Page<Blog> blogs;
        if(s.isPresent()){
            blogs = blogService.findByName(s.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
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
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDateUpdate(new Date());
        blogService.save(blog);
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
