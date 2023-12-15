package org.narainox.blog.application.backend.service;
import org.narainox.blog.application.backend.payloads.PostDto;
import org.narainox.blog.application.backend.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto,Integer categoryId,Long userId);
    String deletePost(Integer PostId);
    PostDto updatePost(PostDto postDto,Integer postId);
    PostDto getPostById(Integer postId);
    PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDirection);
    List<PostDto> getPostByCategory(Integer categoryId);
    List<PostDto> getPostByUser(Long userId);
    List<PostDto> searchPost(String keyword);

}
