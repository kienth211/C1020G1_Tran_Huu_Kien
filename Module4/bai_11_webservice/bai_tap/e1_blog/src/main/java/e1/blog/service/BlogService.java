package e1.blog.service;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog Blog);
    void delete(Integer id);
    List<Blog> findAllByCategory(Category category);
    Page<Blog> findByName(String name, Pageable pageable);
}
