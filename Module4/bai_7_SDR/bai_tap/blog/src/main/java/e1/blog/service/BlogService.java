package e1.blog.service;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Integer id);
    void save(Blog Blog);
    void delete(Integer id);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findByName(String name, Pageable pageable);
}
