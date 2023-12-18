package org.narainox.blog.application.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.narainox.blog.application.backend.entity.Comments;
import org.narainox.blog.application.backend.entity.Post;
import org.narainox.blog.application.backend.exception.ResourceNotFoundException;
import org.narainox.blog.application.backend.payloads.CommentDto;
import org.narainox.blog.application.backend.repository.CommentRepository;
import org.narainox.blog.application.backend.repository.PostRepository;
import org.narainox.blog.application.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        Comments comments = modelMapper.map(commentDto, Comments.class);
        comments.setPost(post);
        Comments save = commentRepository.save(comments);
        return modelMapper.map(save,CommentDto.class);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comments comments = commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
        commentRepository.delete(comments);
    }
}
