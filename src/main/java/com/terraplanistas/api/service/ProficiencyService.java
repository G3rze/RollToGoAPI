package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Proficiency;
import com.terraplanistas.api.repository.ProficiencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProficiencyService {

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    public List<Proficiency> findAll(){
        return proficiencyRepository.findAll();
    }

    public Proficiency findById(UUID id){
        return proficiencyRepository.findById(id).orElse(null);
    }

    public Proficiency save(Proficiency proficiency){
        return proficiencyRepository.save(proficiency);
    }

    public Proficiency update(Proficiency proficiency){
        return proficiencyRepository.save(proficiency);

    }

    public void deleteById(UUID id){
        proficiencyRepository.deleteById(id);
    }

}
