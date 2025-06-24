package com.terraplanistas.api.service;

import com.terraplanistas.api.model.SpecialDie;
import com.terraplanistas.api.repository.SpecialDieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpecialDieService {

    @Autowired
    private SpecialDieRepository specialDieRepository;

    public java.util.List<SpecialDie> findAll() {
        return specialDieRepository.findAll();
    }

    public SpecialDie findById(UUID id) {
        return specialDieRepository.findById(id).orElse(null);
    }

    public SpecialDie save(SpecialDie specialDie) {
        return specialDieRepository.save(specialDie);
    }

    public SpecialDie update(SpecialDie specialDie) {
        return specialDieRepository.save(specialDie);
    }

    public void deleteById(java.util.UUID id) {
        specialDieRepository.deleteById(id);
    }

}
