package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Sense;
import com.terraplanistas.api.repository.SenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SenseService {

    @Autowired
    private SenseRepository senseRepository;

    public List<Sense> findAll() {
        return senseRepository.findAll();
    }

    public Sense findById(UUID id) {
        return senseRepository.findById(id).orElse(null);
    }

    public Sense save(Sense sense) {
        return senseRepository.save(sense);
    }

    public Sense update(Sense sense) {
        return senseRepository.save(sense);
    }

    public void deleteById(UUID id) {
        senseRepository.deleteById(id);
    }

}
