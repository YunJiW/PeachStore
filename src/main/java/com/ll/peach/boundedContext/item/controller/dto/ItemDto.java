package com.ll.peach.boundedContext.item.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String categoryName;

    public ItemDto(Long id, String name, int price, int quantity, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryName = categoryName;
    }
}
