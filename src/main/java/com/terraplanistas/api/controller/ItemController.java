package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Item;
import com.terraplanistas.api.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable UUID id) {
        return itemRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping
    public Item update(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        itemRepository.deleteById(id);
    }


}
