package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Species;
import com.terraplanistas.api.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpeciesService {

    @Autowired
    private SpeciesRepository speciesRepository;

    public List<Species> findAll(){
        return speciesRepository.findAll();
    }

    public Species findById(UUID id){
        return speciesRepository.findById(id).orElse(null);
    }

    public Species save(Species species){
        return speciesRepository.save(species);
    }

    public Species update(Species species){
        return speciesRepository.save(species);
    }

    public void deleteById(UUID id){
        speciesRepository.deleteById(id);
    }

}
