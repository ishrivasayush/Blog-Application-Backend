package org.narainox.blog.application.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts=new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable
            (
                    name = "user_role",
                    joinColumns = @JoinColumn(name = "user",referencedColumnName = "id"),
                    inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id")
            )
    private Set<Role> roles=new HashSet<>();

}
