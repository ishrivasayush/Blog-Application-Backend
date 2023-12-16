package org.narainox.blog.application.backend.repository;

import org.narainox.blog.application.backend.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments,Long> {

}
