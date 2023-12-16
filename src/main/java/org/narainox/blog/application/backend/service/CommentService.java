package org.narainox.blog.application.backend.service;

import org.narainox.blog.application.backend.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Integer postId);
    void deleteComment(Long commentId);
}
