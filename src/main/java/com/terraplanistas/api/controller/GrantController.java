package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Grant;
import com.terraplanistas.api.service.GrantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/grants")
public class GrantController {

    @Autowired
    private GrantService grantService;

    @GetMapping
    public List<Grant> findAll() {
        return grantService.findAll();
    }

    @GetMapping("/{id}")
    public Grant findById(@PathVariable UUID id) {
        return grantService.findById(id);
    }

    @PostMapping
    public Grant save(@RequestBody Grant grant) {
        return grantService.save(grant);
    }

    @PutMapping
    public Grant update(@RequestBody Grant grant) {
        return grantService.update(grant);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        grantService.deleteById(id);
    }

}
