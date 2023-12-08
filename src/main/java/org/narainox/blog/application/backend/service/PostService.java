package org.narainox.blog.application.backend.service;
import org.narainox.blog.application.backend.entity.Post;
import org.narainox.blog.application.backend.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer categoryId,Long userId);
    String deletePost(Integer PostId);
    Post updatePost(PostDto postDto,Integer postId);
    Post getPostById(Integer postId);
    List<Post> getAllPost();
    List<Post> getPostByCategory(Integer categoryId);
    List<Post> getPostByUser(Long userId);
    List<Post> searchPost(String keyword);

}
