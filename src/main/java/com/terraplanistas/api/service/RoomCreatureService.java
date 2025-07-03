package com.terraplanistas.api.service;

import com.terraplanistas.api.model.RoomCreature;
import com.terraplanistas.api.repository.RoomCreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomCreatureService {

    @Autowired
    private RoomCreatureRepository roomCreatureRepository;

    public List<RoomCreature> findAll(){
        return roomCreatureRepository.findAll();
    }

    public RoomCreature findById(UUID id){
        return roomCreatureRepository.findById(id).orElse(null);
    }

    public RoomCreature save(RoomCreature roomCreature){
        return roomCreatureRepository.save(roomCreature);
    }

    public RoomCreature update(RoomCreature roomCreature){
        return roomCreatureRepository.save(roomCreature);
    }

    public void deleteById(UUID id){
        roomCreatureRepository.deleteById(id);
    }

}
