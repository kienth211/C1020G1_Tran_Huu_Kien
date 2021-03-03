package e1.blog.repository;

import e1.blog.model.Blog;
import e1.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByOrderByDateUpdateDesc(Pageable pageable);
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findByName(String name, Pageable pageable);
}
