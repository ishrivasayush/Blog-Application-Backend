package org.narainox.blog.application.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "Comments")
public class Camments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
