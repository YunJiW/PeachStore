package com.ll.peach.boundedContext.category.entity;


import com.ll.peach.base.entity.BaseEntity;
import com.ll.peach.boundedContext.item.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Getter
public class Category extends BaseEntity {

    //이름이 중복되지 않게.
    @Column(unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "category")
    List<Item> items = new ArrayList<>();

}
