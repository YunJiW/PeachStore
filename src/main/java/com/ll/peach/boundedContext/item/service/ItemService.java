package com.ll.peach.boundedContext.item.service;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.category.service.CategoryService;
import com.ll.peach.boundedContext.item.controller.dto.ItemDto;
import com.ll.peach.boundedContext.item.entity.Item;
import com.ll.peach.boundedContext.item.entity.ItemType;
import com.ll.peach.boundedContext.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final CategoryService categoryService;


    @Transactional
    public RsData<Item> createItem(String name, ItemType itemType, int price, int quantity, Category category) {
        Item findItem = findByItemName(name);

        if (findItem != null) {
            return RsData.of("F-1", "이미 있는 상품입니다.", findItem);
        }
        //이미 있는 카테고리인 경우는 만들필요없음
        //없는 카테고리인 경우 만들어져야함.
        Item item = Item.builder()
                .name(name)
                .itemType(itemType)
                .price(price)
                .quantity(quantity)
                .build();

        item.addCategory(category);

        itemRepository.save(item);

        return RsData.of("S-1", "상품 추가 완료", item);
    }

    @Transactional
    public RsData<ItemDto> updateItem(Item item, String name, ItemType itemType, int price, int quantity, Category category) {

        item.updateItem(name, itemType, price, quantity, category);
        itemRepository.save(item);

        ItemDto itemDto = new ItemDto(item.getId(),item.getName(),item.getPrice(),item.getQuantity(),item.getCategory().getName());

        return RsData.of("S-1", "상품 수정완료", itemDto);
    }


    public Optional<Item> findByItemId(Long id) {
        return itemRepository.findById(id);
    }


    public Item findByItemName(String name) {
        return itemRepository.findByName(name).orElse(null);
    }

    public List<ItemDto> findAllByItemName(String name) {
        return itemRepository.findAllByNameContaining(name).stream()
                .map(item -> new ItemDto(item.getId(), item.getName(), item.getPrice(), item.getQuantity(), item.getCategory().getName()))
                .collect(Collectors.toList());
    }

    /**
     * find items
     * 상품 전체 조회
     */
    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream()
                .map(item -> new ItemDto(item.getId(), item.getName(), item.getPrice(), item.getQuantity(), item.getCategory().getName()))
                .collect(Collectors.toList());
    }
}
