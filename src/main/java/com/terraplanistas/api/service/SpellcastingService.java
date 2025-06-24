package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Spellcasting;
import com.terraplanistas.api.repository.SpellcastingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpellcastingService {

    @Autowired
    private SpellcastingRepository spellcastingRepository;

    public List<Spellcasting> findAll() {
        return spellcastingRepository.findAll();
    }

    public Spellcasting findById(UUID id) {
        return spellcastingRepository.findById(id).orElse(null);
    }

    public Spellcasting save(Spellcasting spellcasting) {
        return spellcastingRepository.save(spellcasting);
    }

    public Spellcasting update(Spellcasting spellcasting) {
        return spellcastingRepository.save(spellcasting);
    }

    public void deleteById(UUID id) {
        spellcastingRepository.deleteById(id);
    }

}
