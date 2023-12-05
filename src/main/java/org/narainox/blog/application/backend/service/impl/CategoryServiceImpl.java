package org.narainox.blog.application.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.narainox.blog.application.backend.entity.Category;
import org.narainox.blog.application.backend.exception.ResourceNotFoundException;
import org.narainox.blog.application.backend.payloads.CategoryDto;
import org.narainox.blog.application.backend.repository.CategoryRepository;
import org.narainox.blog.application.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", " id ", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());
        Category save = categoryRepository.save(category);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", " id ", categoryId));
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", " id ", categoryId));
        categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<CategoryDto> list=new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories) {
            list.add(modelMapper.map(category,CategoryDto.class));
        }
        return list;
    }
}
