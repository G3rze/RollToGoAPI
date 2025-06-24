package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.ItemTag;
import com.terraplanistas.api.service.ItemTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item-tags")
public class ItemTagController {

    @Autowired
    private ItemTagService itemTagService;

    @GetMapping
    public List<ItemTag> findAll() {
        return itemTagService.findAll();
    }

    @GetMapping("/{id}")
    public ItemTag findById(@PathVariable UUID id) {
        return itemTagService.findById(id);
    }

    @PostMapping
    public ItemTag save(@RequestBody ItemTag itemTag) {
        return itemTagService.save(itemTag);
    }

    @PutMapping
    public ItemTag update(@RequestBody ItemTag itemTag) {
        return itemTagService.update(itemTag);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        itemTagService.deleteById(id);
    }

}
