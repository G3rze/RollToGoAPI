package com.terraplanistas.api.service;

import com.terraplanistas.api.model.SpellMaterial;
import com.terraplanistas.api.model.Spellcasting;
import com.terraplanistas.api.repository.SpellMaterialRepository;
import com.terraplanistas.api.repository.SpellcastingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpellMaterialService {

    @Autowired
    private SpellMaterialRepository spellMaterialRepository;

    public List<SpellMaterial> findAll() {
        return spellMaterialRepository.findAll();
    }

    public SpellMaterial findById(UUID id) {
        return spellMaterialRepository.findById(id).orElse(null);
    }

    public SpellMaterial update(SpellMaterial spellMaterial){
        return spellMaterialRepository.save(spellMaterial);
    }

    public SpellMaterial save(SpellMaterial spellMaterial){
        return spellMaterialRepository.save(spellMaterial);
    }


    public void deleteById(UUID id){
        spellMaterialRepository.deleteById(id);
    }


}
