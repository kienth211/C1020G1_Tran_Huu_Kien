package e1.blog.repository;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByOrderByDateUpdateDesc();
    List<Blog> findAllByCategory(Category category);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
