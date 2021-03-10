package e1.blog.service.impl;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import e1.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import e1.blog.repository.BlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findByOrderByDateUpdateDesc();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog Blog) {
        blogRepository.save(Blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAllByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }
}
