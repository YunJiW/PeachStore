package com.ll.peach.boundedContext.item.controller;


import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.service.CategoryService;
import com.ll.peach.boundedContext.item.entity.Item;
import com.ll.peach.boundedContext.item.form.ItemForm;
import com.ll.peach.boundedContext.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("isAnonymous()")
    public RsData<Item> create(@Valid @RequestBody ItemForm itemForm) {
        RsData<Category> category = categoryService.createCategory(itemForm.getCategoryname());

        RsData<Item> Rsdata = itemService.createItem(itemForm.getName(), itemForm.getItemType(), category.getData());

        return Rsdata;
    }

}
