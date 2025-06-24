package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.GrantOptionItem;
import com.terraplanistas.api.service.GrantOptionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grant-option-items")
public class GrantOptionItemController {

    @Autowired
    private GrantOptionItemService grantOptionItemService;

    @GetMapping
    public List<GrantOptionItem> findAll() {
        return grantOptionItemService.findAll();
    }

    @GetMapping("/{id}")
    public GrantOptionItem findById(@PathVariable UUID id) {
        return grantOptionItemService.findById(id);
    }

    @PostMapping
    public GrantOptionItem save(@RequestBody GrantOptionItem grantOptionItem) {
        return grantOptionItemService.save(grantOptionItem);
    }

    @PutMapping
    public GrantOptionItem update(@RequestBody GrantOptionItem grantOptionItem) {
        return grantOptionItemService.update(grantOptionItem);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantOptionItemService.deleteById(id);
    }




}
