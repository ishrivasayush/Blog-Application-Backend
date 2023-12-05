package org.narainox.blog.application.backend.repository;

import org.narainox.blog.application.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
