package org.narainox.blog.application.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="user_name",nullable = false,length = 100)
    private String name;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name="email",nullable = false,unique = true)
    private String email;
    @Column(length = 1000)
    private String about;
}
