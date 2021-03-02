package e1.blog.service.impl;

import e1.blog.model.Blog;
import e1.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import e1.blog.repository.BlogRepository;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository BlogRepository;

    @Override
    public List<Blog> findAll() {
        return BlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return BlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog Blog) {
        BlogRepository.save(Blog);
    }

    @Override
    public void delete(Integer id) {
        BlogRepository.deleteById(id);
    }
}
