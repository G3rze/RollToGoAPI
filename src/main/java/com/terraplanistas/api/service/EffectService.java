package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Effect;
import com.terraplanistas.api.repository.EffectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EffectService {

    @Autowired
    private EffectRepository effectRepository;

    public List<Effect> findAll() {
        return effectRepository.findAll();
    }

    public Effect findById(UUID id) {
        return effectRepository.findById(id).orElse(null);
    }

    public Effect save(Effect effect) {
        return effectRepository.save(effect);
    }

    public Effect update(Effect effect) {
        return effectRepository.save(effect);
    }

    public void deleteById(UUID id) {
        effectRepository.deleteById(id);
    }

}
