package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Spell;
import com.terraplanistas.api.repository.SpellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpellService {

    @Autowired
    private SpellRepository spellRepository;

    public List<Spell> findAll(){
        return spellRepository.findAll();
    }

    public Spell findById(UUID id){
        return spellRepository.findById(id).orElse(null);
    }

    public Spell save(Spell spell){
        return spellRepository.save(spell);
    }

    public Spell update(Spell spell){
        return spellRepository.save(spell);
    }

    public void deleteById(UUID id){
        spellRepository.deleteById(id);
    }

}
