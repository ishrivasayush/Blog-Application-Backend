package org.narainox.blog.application.backend.controllers;
import org.narainox.blog.application.backend.config.ApplicationContents;
import org.narainox.blog.application.backend.payloads.ApiResponse;
import org.narainox.blog.application.backend.payloads.PostDto;
import org.narainox.blog.application.backend.payloads.PostResponse;
import org.narainox.blog.application.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer categoryId,
            @PathVariable Long userId
            )
    {
        PostDto post = postService.createPost(postDto, categoryId, userId);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(
            @PathVariable Long userId
    )
    {
        List<PostDto> users = postService.getPostByUser(userId);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(
            @PathVariable Integer categoryId

    )
    {
        List<PostDto> postResponse= postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber",defaultValue = ApplicationContents.PAGE_NUMBER,required = false)Integer pageNumber,
            @RequestParam(value = "pageSize",defaultValue =ApplicationContents.PAGE_SIZE,required = false)Integer pageSize,
            @RequestParam(value = "sortBy",defaultValue =ApplicationContents.SORT_BY,required = false)String sortBy,
            @RequestParam(value = "sortDirection",defaultValue =ApplicationContents.SORT_BY,required = false) String sortByDirection
            )
    {
        PostResponse postResponse = postService.getAllPost(pageNumber,pageSize,sortBy,sortByDirection);
        return new ResponseEntity<>(postResponse,HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(
            @PathVariable Integer postId
    )
    {
        PostDto post = postService.getPostById(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId)
    {
        String s = postService.deletePost(postId);
        ApiResponse apiResponse=new ApiResponse(s,true);
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @PutMapping("/post/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Integer postId,@RequestBody PostDto postDto)
    {
        PostDto post = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }

    @GetMapping("/post/search/{keyword}")
    public ResponseEntity<List<PostDto>> searchPost(@PathVariable String keyword)
    {
        List<PostDto> postDtos = postService.searchPost(keyword);
        return new ResponseEntity<>(postDtos,HttpStatus.FOUND);
    }
}
