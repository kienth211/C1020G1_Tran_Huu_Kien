package e1.blog.controller;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import e1.blog.service.BlogService;
import e1.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    BlogService blogService;

    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAllCategory() {
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> viewCategory(@PathVariable("id") Long id) {
        List<Blog> blogs = blogService.findAllByCategory(categoryService.findById(id));
        if (blogs.isEmpty()) {
            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
    }
}