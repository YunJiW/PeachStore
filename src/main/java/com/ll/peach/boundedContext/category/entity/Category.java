package com.ll.peach.boundedContext.category.entity;


import com.ll.peach.base.entity.BaseEntity;
import com.ll.peach.boundedContext.item.entity.Item;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
public class Category extends BaseEntity {

    //이름이 중복되지 않게.
    @Column(unique = true)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "category")
    List<Item> items = new ArrayList<>();

}
