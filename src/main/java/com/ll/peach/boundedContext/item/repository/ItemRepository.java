package com.ll.peach.boundedContext.item.repository;

import com.ll.peach.boundedContext.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
