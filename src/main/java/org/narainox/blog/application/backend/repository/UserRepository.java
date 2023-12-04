package org.narainox.blog.application.backend.repository;

import org.narainox.blog.application.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
