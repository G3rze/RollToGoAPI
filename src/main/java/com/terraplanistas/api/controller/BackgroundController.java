package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Background;
import com.terraplanistas.api.service.BackgroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/backgrounds")
public class BackgroundController {

    @Autowired
    private BackgroundService backgroundService;

    @GetMapping
    public List<Background> findAll() {
        return backgroundService.findAll();
    }

    @GetMapping("/{id}")
    public Background findById(@PathVariable UUID id) {
        return backgroundService.findById(id);
    }

    @PostMapping
    public Background save(@RequestBody Background background) {
        return backgroundService.save(background);
    }

    @PutMapping
    public Background update(@RequestBody Background background) {
        return backgroundService.update(background);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        backgroundService.deleteById(id);
    }




}
