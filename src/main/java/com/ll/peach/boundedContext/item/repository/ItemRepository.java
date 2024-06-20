package com.ll.peach.boundedContext.item.repository;

import com.ll.peach.boundedContext.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByName(String name);

    List<Item> findAllByName(String name);
}
