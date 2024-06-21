package com.ll.peach.boundedContext.order.entity;

import com.ll.peach.base.entity.BaseEntity;
import com.ll.peach.boundedContext.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
public class orders extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

}
