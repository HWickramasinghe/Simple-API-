package com.SpringBootAcademy.pos1.repo;

import com.SpringBootAcademy.pos1.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {

    // Find items by name and active status
    List<Item> findAllByItemNameEqualsAndActiveStateEquals(String itemName, boolean active);

    // Find all items by active state
    List<Item> findAllByActiveStateEquals(boolean active);

    // Find all items by active state with pagination
    Page<Item> findAllByActiveStateEquals(boolean active, Pageable pageable);

    Page<Item> findAllByActiveStateEquals(boolean active, PageRequest of);

    int countAllByActiveStateEquals(boolean active);

    //  int countfindAllByActiveStateEquals(boolean active);

   // int ccccccfindAllByActiveStateEquals(boolean active);



    // int countfindAllByActiveStateEquals(boolean active);
}
