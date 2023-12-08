package org.narainox.blog.application.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.narainox.blog.application.backend.entity.Category;
import org.narainox.blog.application.backend.entity.Post;
import org.narainox.blog.application.backend.entity.User;
import org.narainox.blog.application.backend.exception.ResourceNotFoundException;
import org.narainox.blog.application.backend.payloads.PostDto;
import org.narainox.blog.application.backend.repository.CategoryRepository;
import org.narainox.blog.application.backend.repository.PostRepository;
import org.narainox.blog.application.backend.repository.UserRepository;
import org.narainox.blog.application.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Post createPost(PostDto postDto) {
        return postRepository.save(modelMapper.map(postDto,Post.class));
    }
    @Override
    public String deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        postRepository.delete(post);
        return "Post Deleted SuccessFully!";
    }

    @Override
    public Post updatePost(PostDto postDto, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        post.setContent(modelMapper.map(post,PostDto.class).getContent());
        post.setTitle(modelMapper.map(post,PostDto.class).getTitle());
        return postRepository.save(post);
    }

    @Override
    public Post getPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        return post;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category", categoryId));
        return postRepository.findByCategory(category);
    }

    @Override
    public List<Post> getPostByUser(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
        return postRepository.findByUser(user);
    }

    @Override
    public List<Post> searchPost(String keyword) {
        return null;
    }
}
