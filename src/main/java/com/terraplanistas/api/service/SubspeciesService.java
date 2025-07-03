package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Subspecies;
import com.terraplanistas.api.repository.SubspeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubspeciesService {

    @Autowired
    private SubspeciesRepository subspeciesRepository;

    public List<Subspecies> findAll() {
        return subspeciesRepository.findAll();
    }

    public Subspecies findById(UUID id) {
        return subspeciesRepository.findById(id).orElse(null);
    }

    public Subspecies save(Subspecies subspecies) {
        return subspeciesRepository.save(subspecies);
    }

    public Subspecies update(Subspecies subspecies) {
        return subspeciesRepository.save(subspecies);
    }

    public void deleteById(UUID id) {
        subspeciesRepository.deleteById(id);
    }

}
