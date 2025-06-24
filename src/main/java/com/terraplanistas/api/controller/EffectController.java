package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Effect;
import com.terraplanistas.api.service.EffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/effects")
public class EffectController {

    @Autowired
    private EffectService effectService;

    @GetMapping
    public List<Effect> findAll() {
        return effectService.findAll();
    }

    @GetMapping("/{id}")
    public Effect findById(@PathVariable UUID id) {
        return effectService.findById(id);
    }

    @PostMapping
    public Effect save(@RequestBody Effect effect) {
        return effectService.save(effect);
    }

    @PutMapping
    public Effect update(@RequestBody Effect effect) {
        return effectService.update(effect);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        effectService.deleteById(id);
    }



}
