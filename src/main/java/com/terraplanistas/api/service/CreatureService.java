package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Creature;
import com.terraplanistas.api.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CreatureService {

    @Autowired
    private CreatureRepository creatureRepository;

    public List<Creature> findAll() {
        return creatureRepository.findAll();
    }

    public Creature findById(UUID id) {
        return creatureRepository.findById(id).orElse(null);
    }

    public Creature save(Creature creature) {
        return creatureRepository.save(creature);
    }

    public Creature update(Creature creature) {
        return creatureRepository.save(creature);
    }

    public void deleteById(UUID id) {
        creatureRepository.deleteById(id);
    }

}
