package com.ll.peach.boundedContext.category.controller;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.form.CategoryForm;
import com.ll.peach.boundedContext.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService categoryService;

    @PostMapping
    public RsData<Category> create(@Valid @RequestBody CategoryForm categoryForm) {
        RsData<Category> data = categoryService.createCategory(categoryForm.getName());
        return data;
    }
}
