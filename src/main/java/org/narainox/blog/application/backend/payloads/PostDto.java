package org.narainox.blog.application.backend.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.narainox.blog.application.backend.entity.Category;
import org.narainox.blog.application.backend.entity.User;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDto category;
    private UserDto user;

}
