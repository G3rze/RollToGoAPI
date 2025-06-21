package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.Ability;
import com.terraplanistas.api.service.AbilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ability")
public class AbilityController {

    @Autowired
    AbilityService abilityService;

    @GetMapping
    public List<Ability> getAllAbility() {
        return abilityService.findAll();
    }

    @GetMapping("/{id}")
    public Ability getAbilityById(@PathVariable UUID id) {
        return abilityService.findById(id);
    }

    @PostMapping
    public Ability createAbility(@RequestBody Ability ability) {
        return abilityService.save(ability);
    }

    @PutMapping
    public Ability updateAbility(@RequestBody Ability ability) {
        return abilityService.update(ability);
    }

    @DeleteMapping("/{id}")
    public void deleteAbility(@PathVariable UUID id) {
        abilityService.deleteById(id);
    }

}
