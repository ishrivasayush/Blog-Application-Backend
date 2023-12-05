package org.narainox.blog.application.backend.controllers;

import jakarta.validation.Valid;
import org.narainox.blog.application.backend.payloads.ApiResponse;
import org.narainox.blog.application.backend.payloads.CategoryDto;
import org.narainox.blog.application.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategoryHandler(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto category=categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategoryHandler(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId)
    {
        CategoryDto category=categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(category,HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryByIdHandler(@PathVariable Integer categoryId)
    {
        CategoryDto category=categoryService.getCategoryById(categoryId);
        return new ResponseEntity<>(category,HttpStatus.FOUND);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategoryHandler(@PathVariable Integer categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("Category Deleted Successfully .",true),HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategoryHandler()
    {
        List<CategoryDto> category=categoryService.getAllCategory();
        return new ResponseEntity<>(category,HttpStatus.FOUND);
    }
}
