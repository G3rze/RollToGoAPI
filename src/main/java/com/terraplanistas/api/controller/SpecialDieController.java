package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.SpecialDie;
import com.terraplanistas.api.service.SpecialDieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/special-dice")
public class SpecialDieController {

    @Autowired
    private SpecialDieService specialDieService;

    @GetMapping
    public List<SpecialDie> findAll() {
        return specialDieService.findAll();
    }

    @GetMapping("/{id}")
    public SpecialDie findById(@PathVariable UUID id) {
        return specialDieService.findById(id);
    }

    @PostMapping
    public SpecialDie save(@RequestBody SpecialDie specialDie) {
        return specialDieService.save(specialDie);
    }

    @PutMapping
    public SpecialDie update(@RequestBody SpecialDie specialDie) {
        return specialDieService.update(specialDie);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        specialDieService.deleteById(id);
    }

}
