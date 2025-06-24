package com.terraplanistas.api.service;

import com.terraplanistas.api.model.LevelProgression;
import com.terraplanistas.api.repository.LevelProgressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LevelProgressionService {

    @Autowired
    private LevelProgressionRepository levelProgressionRepository;

    public List<LevelProgression> findAll() {
        return levelProgressionRepository.findAll();
    }

    public LevelProgression findById(UUID id) {
        return levelProgressionRepository.findById(id).orElse(null);
    }

    public LevelProgression save(LevelProgression levelProgression) {
        return levelProgressionRepository.save(levelProgression);
    }

    public LevelProgression update(LevelProgression levelProgression) {
        return levelProgressionRepository.save(levelProgression);

    }

    public void deleteById(UUID id) {
        levelProgressionRepository.deleteById(id);
    }


}
