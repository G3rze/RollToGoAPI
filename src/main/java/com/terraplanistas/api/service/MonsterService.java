package com.terraplanistas.api.service;

import com.terraplanistas.api.model.Monster;
import com.terraplanistas.api.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MonsterService {

    @Autowired
    private MonsterRepository monsterRepository;

    public List<Monster> findAll(){
        return monsterRepository.findAll();
    }

    public Monster findById(UUID id){
        return monsterRepository.findById(id).orElse(null);
    }

    public Monster save(Monster monster){
        return monsterRepository.save(monster);
    }

    public Monster update(Monster monster){
        return monsterRepository.save(monster);

    }

    public void deleteById(UUID id){
        monsterRepository.deleteById(id);
    }


}
