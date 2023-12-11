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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public PostDto createPost(PostDto postDto,Integer categoryId,Long userId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category", categoryId));
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
        Post post=modelMapper.map(postDto,Post.class);

        post.setImageName("Default.png");
        post.setUser(user);
        post.setAddedDate(new Date());
        post.setCategory(category);

        Post save = postRepository.save(post);
        return modelMapper.map(save,PostDto.class);
    }
    @Override
    public String deletePost(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        postRepository.delete(post);
        return "Post Deleted SuccessFully!";
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        post.setContent(modelMapper.map(post,PostDto.class).getContent());
        post.setTitle(modelMapper.map(post,PostDto.class).getTitle());
        Post save = postRepository.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost(Integer pageNumber,Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize);
        Page<Post> posts = postRepository.findAll(pageable);
        List<PostDto> postDtos=new ArrayList<>();
        for (Post post:posts)
        {
            postDtos.add(modelMapper.map(post,PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category", categoryId));
        List<Post> posts = postRepository.findByCategory(category);
        List<PostDto> postDtos=new ArrayList<>();
        for (Post post:posts)
        {
            postDtos.add(modelMapper.map(post,PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getPostByUser(Long userId) {
        User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","UserId",userId));
        List<Post> posts = postRepository.findByUser(user);
        List<PostDto> postDtos=new ArrayList<>();
        for (Post post:posts)
        {
            postDtos.add(modelMapper.map(post,PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {

        return null;
    }
}
