package com.terraplanistas.api.service;

import com.terraplanistas.api.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.terraplanistas.api.model.Class;

import java.util.List;
import java.util.UUID;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public Class findById(UUID id) {
        return classRepository.findById(id).orElse(null);
    }

    public Class save(Class clazz) {
        return classRepository.save(clazz);
    }

    public Class update(Class clazz) {
        return classRepository.save(clazz);
    }

    public void deleteById(UUID id) {
        classRepository.deleteById(id);
    }

}
