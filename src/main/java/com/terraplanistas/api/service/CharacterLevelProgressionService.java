package com.terraplanistas.api.service;

import com.terraplanistas.api.model.CharacterLevelProgression;
import com.terraplanistas.api.repository.CharacterLevelProgressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CharacterLevelProgressionService {

    @Autowired
    private CharacterLevelProgressionRepository characterLevelProgressionRepository;

    public Optional<CharacterLevelProgression> findById(UUID id) {
        return characterLevelProgressionRepository.findById(id);
    }

    public List<CharacterLevelProgression> findAll() {
        return characterLevelProgressionRepository.findAll();
    }

    public CharacterLevelProgression save(CharacterLevelProgression characterLevelProgression) {
        return characterLevelProgressionRepository.save(characterLevelProgression);
    }

    public void deleteById(UUID id) {
        characterLevelProgressionRepository.deleteById(id);
    }
}
