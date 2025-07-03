package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Skill;
import com.terraplanistas.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill findById(UUID id) {
        return skillRepository.findById(id).orElse(null);
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteById(UUID id) {
        skillRepository.deleteById(id);
    }

}
