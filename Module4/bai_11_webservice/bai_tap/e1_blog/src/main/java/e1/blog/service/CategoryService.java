package e1.blog.service;

import e1.blog.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    void save(Category category);

    void remove(Long id);
}
