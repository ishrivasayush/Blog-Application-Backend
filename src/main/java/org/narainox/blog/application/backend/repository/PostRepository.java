package org.narainox.blog.application.backend.repository;


import org.narainox.blog.application.backend.entity.Category;
import org.narainox.blog.application.backend.entity.Post;
import org.narainox.blog.application.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
