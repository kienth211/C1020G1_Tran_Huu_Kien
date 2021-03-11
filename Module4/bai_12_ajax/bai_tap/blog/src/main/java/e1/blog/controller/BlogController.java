package e1.blog.controller;

import e1.blog.model.Category;
import e1.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import e1.blog.model.Blog;
import e1.blog.service.BlogService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

//@Controller
@CrossOrigin
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> provinces() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> receiveHome(@PageableDefault(page = 0, size = 2) Pageable pageable) {
        return blogService.findAll(pageable);
    }

    @GetMapping("")
    public String showHome(Model model, @PageableDefault(size = 2) Pageable pageable) {
//        model.addAttribute("blogs", receiveHome(pageable));
        return "home";
    }

    @GetMapping(value = "/reload", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> reloadBlog(@RequestParam(value = "size") Integer size) {
        Pageable pageable = PageRequest.of(0, size);
        return blogService.findAll(pageable);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> searchByName(@RequestParam(value = "name") String name,@PageableDefault(page = 0, size = 2) Pageable pageable) {
        return blogService.findByName(name, pageable);
    }

    @GetMapping(value = "/search_2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> reloadSearch(@RequestParam(value = "size") Integer size, @RequestParam(value = "name") String name) {
        Pageable pageable = PageRequest.of(0, size);
        return blogService.findByName(name, pageable);
    }

}
