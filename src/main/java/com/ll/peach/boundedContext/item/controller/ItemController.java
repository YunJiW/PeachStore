package com.ll.peach.boundedContext.item.controller;


import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.service.CategoryService;
import com.ll.peach.boundedContext.item.controller.dto.ItemDto;
import com.ll.peach.boundedContext.item.entity.Item;
import com.ll.peach.boundedContext.item.form.ItemForm;
import com.ll.peach.boundedContext.item.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        log.info("상품 추가");
        RsData<Category> category = categoryService.createCategory(itemForm.getCategoryname());

        RsData<Item> Rsdata = itemService.createItem(itemForm.getName(), itemForm.getItemType(), itemForm.getPrice(), itemForm.getQuantity(), category.getData());

        return Rsdata;
    }

    @GetMapping
    @PreAuthorize("isAnonymous()")
    public List<ItemDto> itemList() {
        log.info("상품 전체 조회");

        return itemService.findAll();
    }

    @GetMapping("/search")
    @PreAuthorize("isAnonymous()")
    public List<ItemDto> seachItem(@RequestParam("name") String name) {
        log.info("특정 상품 이름 조회:" + name);

        return itemService.findAllByItemName(name);
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAnonymous()")
    public ItemDto ItemById(@PathVariable("id") Long id) {
        Optional<Item> findItem = itemService.findByItemId(id);

        return findItem.map(item -> new ItemDto(item.getId(), item.getName(), item.getPrice(), item.getQuantity(), item.getCategory().getName())).orElse(null);
    }

    @PostMapping("/{id}")
    @PreAuthorize("isAnonymous()")
    public RsData<ItemDto> updateItem(@PathVariable("id") Long id, @Valid @RequestBody ItemForm itemForm) {
        Optional<Item> findItem = itemService.findByItemId(id);

        RsData<Category> category = categoryService.createCategory(itemForm.getCategoryname());

        if (!findItem.isPresent()) {
            return RsData.of("F-33", "상품이 존재하지 않습니다.");
        }
        Item item = findItem.get();
        RsData<ItemDto> itemRsData = itemService.updateItem(item, itemForm.getName(), itemForm.getItemType(), itemForm.getPrice(), itemForm.getQuantity(), category.getData());
        return itemRsData;

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("isAnonymous()")
    public RsData<ItemDto> removeItem(@PathVariable("id") Long id) {
        Optional<Item> FindItem = itemService.findByItemId(id);

        if (!FindItem.isPresent()) {
            return RsData.of("F-1", "존재하지 않은 상품입니다.");
        }

        Item item = FindItem.get();


        RsData<ItemDto> itemDtoRsData = itemService.deleteItem(item);

        return itemDtoRsData;
    }

}
