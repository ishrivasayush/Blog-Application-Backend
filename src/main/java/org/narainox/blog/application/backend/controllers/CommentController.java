package org.narainox.blog.application.backend.controllers;

import org.narainox.blog.application.backend.payloads.ApiResponse;
import org.narainox.blog.application.backend.payloads.CommentDto;
import org.narainox.blog.application.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,@PathVariable Integer postId)
    {
        CommentDto comment = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> createComment(@PathVariable Long commentId)
    {
        commentService.deleteComment(commentId);
        ApiResponse apiResponse=new ApiResponse("Comment Deleted Successfully.",true);
        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }
}
