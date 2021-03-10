package e1.blog.controller;

import e1.blog.model.Category;
import e1.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import e1.blog.model.Blog;
import e1.blog.service.BlogService;

import java.util.List;


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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> showHome() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public ResponseEntity<Blog> viewBlog(@PathVariable("id") Integer id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
    }
}
