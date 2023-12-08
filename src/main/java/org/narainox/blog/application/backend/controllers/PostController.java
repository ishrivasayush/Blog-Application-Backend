package org.narainox.blog.application.backend.controllers;

import org.narainox.blog.application.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post/")
public class PostController {
    @Autowired
    private PostService postService;
}
