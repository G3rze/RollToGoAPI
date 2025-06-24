package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Damage;
import com.terraplanistas.api.service.DamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/damage")
public class DamageController {

    @Autowired
    private DamageService damageService;

    @GetMapping
    public List<Damage> findAll() {
        return damageService.findAll();
    }

    @GetMapping("/{id}")
    public Damage findById(@PathVariable UUID id){
        return damageService.findById(id);
    }

    @PostMapping
    public Damage save(@RequestBody Damage damage) {
        return damageService.save(damage);
    }

    @PutMapping
    public Damage update(@RequestBody Damage damage) {
        return damageService.update(damage);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        damageService.deleteById(id);
    }
}
