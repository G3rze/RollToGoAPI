package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.LimitedUsage;
import com.terraplanistas.api.service.LimitedUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/limited-usage")
public class LimitedUsageController {

    @Autowired
    private LimitedUsageService limitedUsageService;

    @GetMapping
    public List<LimitedUsage> findAll() {
        return limitedUsageService.findAll();
    }

    @GetMapping("/{id}")
    public LimitedUsage findById(@PathVariable UUID id) {
        return limitedUsageService.findById(id);
    }

    @PostMapping
    public LimitedUsage save(@RequestBody LimitedUsage limitedUsage) {
        return limitedUsageService.save(limitedUsage);
    }

    @PutMapping
    public LimitedUsage update(@RequestBody LimitedUsage limitedUsage) {
        return limitedUsageService.update(limitedUsage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        limitedUsageService.deleteById(id);
    }




}
