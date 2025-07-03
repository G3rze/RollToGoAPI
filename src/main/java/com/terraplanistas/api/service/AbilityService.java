package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Ability;
import com.terraplanistas.api.repository.AbilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AbilityService {

    @Autowired
    private AbilityRepository abilityRepository;

    public List<Ability> findAll(){
        return abilityRepository.findAll();
    }

    public Ability findById(UUID id){
        return abilityRepository.findById(id).orElse(null);
    }

    public Ability save(Ability ability){
        return abilityRepository.save(ability);
    }

    public Ability update(Ability ability){
        return abilityRepository.save(ability);
    }

    public void deleteById(UUID id){
        abilityRepository.deleteById(id);
    }

}
