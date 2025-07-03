package com.terraplanistas.api.service;

import com.terraplanistas.api.repository.CharacterRepository;
import com.terraplanistas.api.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findById(UUID id) {
        return characterRepository.findById(id).orElse(null);
    }

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public Character update(Character character) {
        return characterRepository.save(character);
    }

    public void deleteById(UUID id) {
        characterRepository.deleteById(id);
    }

}
