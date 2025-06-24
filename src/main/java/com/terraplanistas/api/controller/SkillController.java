package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Skill;
import com.terraplanistas.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Service
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping
    public List<Skill> findAll() {
        return skillService.findAll();
    }

    @GetMapping("/{id}")
    public Skill findById(@PathVariable UUID id) {
        return skillService.findById(id);
    }

    @PostMapping
    public Skill save(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @PutMapping
    public Skill update(@RequestBody Skill skill) {
        return skillService.update(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        skillService.deleteById(id);
    }

}
