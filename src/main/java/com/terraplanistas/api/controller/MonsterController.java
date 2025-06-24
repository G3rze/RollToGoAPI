package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Monster;
import com.terraplanistas.api.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/monsters")
public class MonsterController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping
    public List<Monster> findAll() {
        return monsterService.findAll();
    }

    @GetMapping("/{id}")
    public Monster findById(@PathVariable UUID id) {
        return monsterService.findById(id);
    }

    @PostMapping
    public Monster save(@RequestBody Monster monster) {
        return monsterService.save(monster);
    }

    @PutMapping
    public Monster update(@RequestBody Monster monster) {
        return monsterService.update(monster);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        monsterService.deleteById(id);
    }

}
