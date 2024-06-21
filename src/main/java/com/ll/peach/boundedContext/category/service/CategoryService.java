package com.ll.peach.boundedContext.category.service;


import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Transactional
    public RsData<Category> createCategory(String name){
        Category category = findByCategoryName(name);
        if(category != null){
            return RsData.of("F-1","중복되는 카테고리입니다.",category);
        }

        Category categories = Category.builder()
                .name(name)
                .build();

        categoryRepository.save(categories);

        return RsData.of("S-1","카테고리 생성완료",categories);
    }

    public Category findByCategoryName(String name){
        return categoryRepository.findByName(name).orElse(null);
    }

}
