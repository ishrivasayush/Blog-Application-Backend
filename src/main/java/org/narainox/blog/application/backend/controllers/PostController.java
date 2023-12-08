package org.narainox.blog.application.backend.controllers;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.narainox.blog.application.backend.entity.Post;
import org.narainox.blog.application.backend.payloads.PostDto;
import org.narainox.blog.application.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer categoryId,
            @PathVariable Long userId
            )
    {
        PostDto post = postService.createPost(postDto, categoryId, userId);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

}
