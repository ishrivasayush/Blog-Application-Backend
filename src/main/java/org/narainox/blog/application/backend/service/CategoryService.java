package org.narainox.blog.application.backend.service;

import org.narainox.blog.application.backend.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);

    void deleteCategory(Integer categoryId);

    List<CategoryDto> getAllCategory();
}
