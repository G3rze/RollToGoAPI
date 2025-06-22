package com.terraplanistas.api.service;

import com.terraplanistas.api.model.AbilityScoreImprovement;
import com.terraplanistas.api.repository.AbilityScoreImprovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AbilityScoreImprovementService {

    @Autowired
    private AbilityScoreImprovementRepository abilityScoreImprovementRepository;

    public List<AbilityScoreImprovement> findAll(){
        return abilityScoreImprovementRepository.findAll();
    }

    public AbilityScoreImprovement save(AbilityScoreImprovement abilityScoreImprovement) {
        return abilityScoreImprovementRepository.save(abilityScoreImprovement);
    }

    public AbilityScoreImprovement update(AbilityScoreImprovement abilityScoreImprovement) {
        return abilityScoreImprovementRepository.save(abilityScoreImprovement);
    }

    public void deleteById(UUID id) {
        abilityScoreImprovementRepository.deleteById(id);
    }

    public AbilityScoreImprovement findById(UUID id) {
        return abilityScoreImprovementRepository.findById(id).orElse(null);
    }

}
