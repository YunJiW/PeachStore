package com.ll.peach.boundedContext.item.service;

import com.ll.peach.base.rsData.RsData;
import com.ll.peach.boundedContext.category.entity.Category;
import com.ll.peach.boundedContext.item.entity.Item;
import com.ll.peach.boundedContext.item.entity.ItemType;
import com.ll.peach.boundedContext.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


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


    public Item findByItemName(String name) {
        return itemRepository.findByName(name).orElse(null);
    }

    public List<Item> findAllByItemName(String name) {
        return itemRepository.findAllByName(name);
    }

    /**
     * find items
     * 상품 전체 조회
     */
    public List<Item> findAll() {
        return itemRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }
}
