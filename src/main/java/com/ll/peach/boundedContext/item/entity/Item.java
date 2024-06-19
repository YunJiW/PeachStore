package com.ll.peach.boundedContext.item.entity;


import com.ll.peach.base.entity.BaseEntity;
import com.ll.peach.boundedContext.category.entity.Category;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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


}
