package com.terraplanistas.api.controller;

import com.terraplanistas.api.model.AbilityScoreImprovement;
import com.terraplanistas.api.service.AbilityScoreImprovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/ability_score_improvement")
public class AbilityScoreImprovementController{

    @Autowired
    private AbilityScoreImprovementService abilityScoreImprovementService;

    @GetMapping
    public List<AbilityScoreImprovement> findAll(){
        return abilityScoreImprovementService.findAll();
    }

    @GetMapping("/{id}")
    public AbilityScoreImprovement findById(@PathVariable UUID id) {
        return abilityScoreImprovementService.findById(id);
    }

    @PutMapping
    public AbilityScoreImprovement update(AbilityScoreImprovement abilityScoreImprovement) {
        return abilityScoreImprovementService.update(abilityScoreImprovement);
    }

    @PostMapping
    public AbilityScoreImprovement save(AbilityScoreImprovement abilityScoreImprovement) {
        return abilityScoreImprovementService.save(abilityScoreImprovement);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        abilityScoreImprovementService.deleteById(id);
    }

}
