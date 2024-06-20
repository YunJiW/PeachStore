package com.ll.peach.boundedContext.item.entity;


import com.ll.peach.base.entity.BaseEntity;
import com.ll.peach.boundedContext.category.entity.Category;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Item extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemType itemType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private int price;

    private int quantity;

    public void addCategory(Category category) {

        if (this.category != null) {
            this.category.getItems().remove(this);
        }
        this.category = category;
        category.getItems().add(this);
    }

}
