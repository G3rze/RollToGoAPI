package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Damage;
import com.terraplanistas.api.repository.DamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DamageService {

    @Autowired
    private DamageRepository damageRepository;

    public List<Damage> findAll() {
        return damageRepository.findAll();
    }

    public Damage findById(UUID id) {
        return damageRepository.findById(id).orElse(null);
    }

    public Damage save(Damage damage) {
        return damageRepository.save(damage);
    }

    public Damage update(Damage damage) {
        return damageRepository.save(damage);
    }

    public void deleteById(UUID id) {
        damageRepository.deleteById(id);
    }

}
