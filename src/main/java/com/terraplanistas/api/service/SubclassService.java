package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Subclass;
import com.terraplanistas.api.repository.SubclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubclassService {

    @Autowired
    private SubclassRepository subclassRepository;

    public List<Subclass> findAll() {
        return subclassRepository.findAll();
    }

    public Subclass findById(UUID id) {
        return subclassRepository.findById(id).orElse(null);
    }

    public Subclass save(Subclass subclass) {
        return subclassRepository.save(subclass);
    }

    public Subclass update(Subclass subclass) {
        return subclassRepository.save(subclass);
    }

    public void deleteById(UUID id) {
        subclassRepository.deleteById(id);
    }

}
