package e1.blog.service;

import e1.blog.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog Blog);
    void delete(Integer id);
}
